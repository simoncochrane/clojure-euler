(use 'clojure.contrib.lazy-seqs)

(defn prime? [x]
  (let [num (Integer/parseInt x)]
    (= num (some #(if (>= % num) % nil) primes))))

;; permutations is wrong! should be rotations
(defn permutations [x]
  (if (<= (count x) 1) [x]
      (reduce into []
	      (for [i (range 0 (count x))]
		(map #(apply str (cons (.charAt x i) %))
		     (permutations (str (subs x 0 i) (subs x (inc i)))))))))

(defn rotations [x]
  (map #(str (subs x %) (subs x 0 %)) (range 0 (count x))))

(defn circular-prime? [x]
  (if (re-find #"2|4|5|6|8|0" x) false
      (every? prime? (rotations x))))

(defn eul35 [upto]
  (+ 2 (count
	(filter #(circular-prime? (str %)) (take-while #(< % upto) primes)))))
