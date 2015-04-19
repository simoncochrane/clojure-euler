
;; this stuff is pretty naive - use clojure.contrib.lazy-seqs instead

(defn get-primes [primes? from]
  "Returns a vector containing all the primes for which the corresponding element
   in primes? is true, beginning at 'from'."
  (loop [i 0 primes []]
    (cond (= i (count primes?)) primes
	  (nth primes? i) (recur (inc i) (conj primes (+ from i)))
	  true (recur (inc i) primes))))

(defn mark-non-primes [primes? base-prime from]
  "Returns a vector with 0th element representing 'from' where all multiples
   of base-prime have been marked false."
  (loop [i 2 new-primes? primes?]
    (cond (> (* base-prime i) (+ (count primes?) from)) new-primes?
	  (< (* base-prime i) from) (recur (inc i) new-primes?)
	  true (recur (inc i) (assoc new-primes? (- (* base-prime i) from) false)))))

(defn mark-prev-primes [primes? prev-primes from]
  "Sets all elements in primes? to false corresponding to multiples of the
   primes specified in prev-primes, where primes? indexes represent all numbers
   beginning at 'from'."
  (loop [pr? primes? prev prev-primes]
    (cond (nil? pr?) []
      (empty? prev) pr?
      true (recur (mark-non-primes pr? (first prev) from) (rest prev)))))

(defn primes-between [from to prev-primes]
  "Returns a vector containing all the primes between and including 'from' and 'to'.
   All primes prior to 'from' must be provided in prev-primes."
  (println "pb" from to "count: " (count prev-primes))
  (let [fr (if (<= from 1) 2 from)
	init-primes? (vec (repeat (- to (dec fr)) true))
	sqrt (int (Math/ceil (Math/sqrt to)))]
    (loop [i fr primes? (mark-prev-primes init-primes? prev-primes fr)]
	(cond (> i sqrt) (get-primes primes? fr)
	      (nth primes? (- i fr)) (recur (inc i) (mark-non-primes primes? i fr))
	      true (recur (inc i) primes?)))))

(def primes
     (lazy-cat [] (map
		   (fn [n] (primes-between
			    (inc (* 10 n)) (* 10 (inc n)) 
			    (if (zero? n) []
				(dorun (println "n: " n) []))))
				;(take-while #(< (* % %) (* 10 (inc n))) primes))))
		   (range 0 3))))


(def primes2
     (lazy-cat [2] (mapcat (fn [n] (primes-between
				   (inc (* 10 n)) (* 10 (inc n))
				   (take 2 primes2)))
			  (iterate inc 0))))

(def test2
     (lazy-cat [] (mapcat #(primes-between (inc (* 10 %1)) (* 10 (inc %1)) [])
				       (iterate inc 0))))

