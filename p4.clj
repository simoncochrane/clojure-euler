
(defn create-palindrome [digits]
  (Integer/parseInt (str digits (apply str (reverse (str digits))))))

(defn has-3d-prd? [num]
  (loop [x 100]
    (cond (and (zero? (rem num x)) (= (count (str (/ num x))) 3)) true
	  (= x 999) false
	  true (recur (inc x)))))

(loop [num 999]
  (let [paln (create-palindrome num)]
	(if (has-3d-prd? paln) paln
	    (recur (dec num)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn log10 [n]
  (/ (Math/log n) (Math/log 10)))



