
(defn sum-divisors [x]
  (reduce + (filter #(zero? (rem x %)) (range 1 (inc (/ x 2))))))

(def sum-div-m (memoize sum-divisors))

(defn amicable-pair [x]
  (let [sum-div (sum-div-m x)]
    (if (= x (sum-div-m sum-div))
      sum-div
      nil)))

(reduce + (filter #(when-let [n (amicable-pair %)] (not= n %)) (range 1 10000)))