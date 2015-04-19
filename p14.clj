(defn p14-seq [n]
  (take-while #(not= % 1)
	      (iterate #(if (even? %) (/ % 2)
			    (inc (* % 3))) n)))

(time
(first (reduce #(if (> (second %1) (second %2)) %1 %2)
	(map #(vector % (count (p14-seq %))) (range 1 1000000)))))

;; try this with memoization




