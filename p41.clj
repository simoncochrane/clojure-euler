; note - check out rotations in seq-utils

; note - cannot be 9 or 8 digit.. why?
; add all the digits together - if the result is divisible by 3 then cannot be prime

(use 'clojure.contrib.lazy-seqs)
(use 'clojure.contrib.seq-utils)

(defn prime? [x]
  (not (some #(zero? (rem x %)) (take-while #(<= (* % %) x) primes))))

(defn permutations [x]
  (if (= (count x) 1)
    (if (.contains "24568" x) nil [x])
    (reduce into []
	    (for [i (range 0 (count x))]
	      (map #(apply str (cons (.charAt x i) %))
		   (permutations (str (subs x 0 i) (subs x (inc i)))))))))

(defn eul41 []
  (some #(if (prime? (Integer/parseInt %)) % nil) 
	(flatten (map #(permutations (subs "987654321" %)) (range 0 9)))))


;; too slow

(defn pandigital? [num]
  (let [num-str (str num)]
    (= (apply str (sort num-str)) (subs "123456789" 0 (count num-str)))))

(defn eul41 []
  (filter pandigital? (take-while #(<= % 987654321) primes)))

 