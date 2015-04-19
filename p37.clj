(use 'clojure.contrib.lazy-seqs)

(defn prime? [num]
  (= num (some #(if (>= % num) % nil) primes)))

(defn trunc-prime? [num]
  (loop [trl num trr num]
    (let [tr-left (int (/ trl 10))
	  tr-right (int (rem trr (Math/pow 10 (int (Math/log10 trr)))))]
      (cond (< tr-left 10) (and (prime? tr-left) (prime? tr-right))
	    (and (prime? tr-left) (prime? tr-right)) (recur tr-left tr-right)
	    :else false))))

(defn eul37 []
  (reduce + (take 11 (filter trunc-prime? primes))))



