(defn factors-sum [x]
  (reduce + (filter #(zero? (rem x %)) (range 1 (inc (/ x 2))))))

(def abundants
     (apply sorted-set (filter #(> (factors-sum %) %) (range 1 28124))))

(defn abundants-sum? [num]
  (some #(contains? abundants (- num %))
	(filter #(< % num) abundants)))

(defn eul23 [x]
  (reduce + (filter (complement abundants-sum?) (range 1 x))))


