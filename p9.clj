(use 'clojure.contrib.math)

(defn pyg-triplets []
  (iterate (fn [[a b]]
	     (let [a (inc a) c? (exact-integer-sqrt (+ (* a a) (* b b)))]
	       (cond
		 (>= a b) (recur [0 (inc b)])
		 (zero? (last c?)) [a b (first c?)]
		 :else (recur [a b]))))
	     [3 4 5]))

(reduce * (first (filter #(= (reduce + %) 1000) (pyg-triplets))))







