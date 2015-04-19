
(defn pandigitals
  ([] (pandigitals 9))
  ([num-digits]
     (if (= 1 num-digits) ["1"]
	 (for [digits (pandigitals (dec num-digits)) idx (range 0 num-digits)]
	   (str (subs digits 0 idx) (str num-digits) (subs digits idx))))))

(defn identity-product [num]
  (loop [len 7 mult-idx 8]
    (let [product (Integer/parseInt (subs num 0 len))
	  multiplicand (Integer/parseInt (subs num len mult-idx))
	  multiplier (Integer/parseInt (subs num mult-idx))]
      (cond (= product (* multiplicand multiplier)) product
	    (= len 1) nil
	    (= (dec mult-idx) len) (recur (dec len) 8)
	    :else (recur len (dec mult-idx))))))

(defn eul32 []
  (reduce + (distinct (filter (complement nil?) 
			      (map identity-product (pandigitals))))))

