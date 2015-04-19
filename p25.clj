(import '(java.math BigInteger))
(use 'clojure.contrib.lazy-seqs)

(defn fibs-and-pos []
  (map #(list (first %) (last %))
       (iterate (fn [[a b pos]] [b (+ a b) (inc pos)]) [1 1 1])))

(defn fib-digits [num]
  (first (filter #(>= (first %) (.pow (BigInteger/valueOf 10) (dec num))) (fibs-and-pos))))
