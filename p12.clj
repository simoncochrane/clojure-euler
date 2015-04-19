
(defn triangles []
     (map first (iterate (fn [[num idx]] [(+ num idx) (inc idx)]) [1 2])))

(defn factors [num]
  (loop [i 1 factors []]
    (if (> (* i i) num)
      factors
      (recur (inc i)
	     (if (zero? (rem num i))
	       (conj factors i (/ num i))
	       factors)))))

(first (filter #(> (count (factors %)) 500) (triangles)))



