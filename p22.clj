(import '(java.lang String))

(defn ordered-names [filename]
  (apply sorted-set (map #(nth % 1)
		   (re-seq #"\"(\w*?)\",?"
			   (slurp filename)))))

(defn letter-score [name]
  (reduce + (map #(- (int %) 64) (seq (.toUpperCase name)))))

(defn name-scores [filename]
    (loop [i 1 names (ordered-names filename) total 0]
      (if (first names)
	(recur (inc i) (rest names) (+ total (* i (letter-score (first names)))))
	total)))
	  
      