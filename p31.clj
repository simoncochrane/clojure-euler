
(defn num-combinations [denom curr-val total]
  (loop [i 0 num 0]
    (let [new-val (+ curr-val (* i denom))]
      (cond (> new-val total) num
	    (= new-val total) (inc num)
	    :else (recur (inc i)
			 (if (= denom 1) num
			     (+ num (num-combinations (if (= denom 50) 20
						   (int (/ denom 2)))
					       new-val total))))))))

(defn eul31 [total]
  (num-combinations 200 0 total))
      
