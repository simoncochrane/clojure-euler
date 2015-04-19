(use 'clojure.set)x

(defn curious? [num den]
  (let [same (intersection #{(rem num 10) (int (/ num 10))}
			   #{(rem den 10) (int (/ den 10))})]
    (and ((complement empty?) same)
	 (every? #(= (/ num den)
		     (/ (Integer/parseInt (.replaceFirst (str num) (str %) ""))
			(Integer/parseInt (.replaceFirst (str den) (str %) ""))))
					  same))))

(defn eul33 []
  (reduce *
	  (for [num (range 10 100) den (range (inc num) 100)
		:when (and (not (zero? (rem den 10))) (curious? num den))]
	    (/ num den))))
