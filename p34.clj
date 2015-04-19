;; check all numbers up to 10,000,000

(defn factorial [num]
  (reduce * (range 2 (inc num))))

(def factorial-m
     (memoize factorial))

(defn fact-sum [num]
  (reduce + (map #(factorial-m (- (int %) 48)) (str num))))

(defn eul34 [upto]
  (reduce + (filter #(= % (fact-sum %)) (range 3 upto))))

