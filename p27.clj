(use 'clojure.contrib.lazy-seqs)

(defn prime? [x]
  (= x (some #(if (>= % x) % nil) primes)))

(defn quad-num-primes [a b]
  (loop [n 0 num 0]
    (if (prime? (+ (* n n) (* a n) b))
      (recur (inc n) (inc num))
      num)))

(defn eul27 [rng]
  (first (sort-by first >
		  (filter #(> (first %) 40)
			  (for [a (range (- rng) rng) b (range (- rng) rng)]
			    [(quad-num-primes a b) (* a b)])))))



