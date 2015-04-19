
(defn pow-sum [num]
  (reduce + (filter #(and (> % 0) (< % 10))
		    (map #(- (int %) 48)
			 (seq (str (. (BigInteger/valueOf 2) pow num)))))))
					       


