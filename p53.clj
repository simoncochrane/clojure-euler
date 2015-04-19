
(defn factorial
  ([n] (factorial n 1))
  ([n acc]
     (if (<= n 0) acc
	 (recur (dec n) (* acc n)))))

(defn ncr [n r] 
  (quot (factorial n) (* (factorial r) (factorial (- n r)))))

(defn eul53 []
  (reduce + (map #(if (> % 1000000) 1 0)
	  (for [n (range 1 101) r (range 1 n)] (ncr n r)))))