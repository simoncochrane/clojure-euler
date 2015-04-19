
(defn tens-pow [num gt]
  (loop [n num i 0]
    (if (>= n gt) i
	(recur (* n 10) (inc i)))))

(defn recurring-decimal [numr denr]
  (loop [remdr (if (> numr denr) (rem numr denr) numr) calcs {} result ""]
    (let [tens-pow (tens-pow remdr denr)
	  num (apply * remdr (repeat tens-pow 10))
	  pos (get calcs remdr)]
      (cond pos (subs result pos)
	    (zero? (rem num denr)) nil
	    :true (recur (rem num denr)
			 (assoc calcs remdr (count result))
			 (str result (apply str (repeat (dec tens-pow) "0"))
			      (int (/ num denr))))))))

(defn eul26 [upto]
  (last (sort-by #(count (second %))
	   (map #(vector % (recurring-decimal 1 %)) (range 1 upto)))))







    
