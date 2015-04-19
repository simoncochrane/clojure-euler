(use '[clojure.set :only (difference)])

(defn multiples [m]
  (map #(str (if (< % 100) "0" "") %)
       (take-while #(< % 988) (iterate #(+ % m) m))))

(defn div-by? [num pos div]
  (zero? (rem (Integer/parseInt (subs num pos (+ pos 3))) div)))

(defn eul43 []
  (let [digits #{\0 \1 \2 \3 \4 \5 \6 \7 \8 \9}]
    (reduce +
	    (for [mult2 (multiples 2) 
		  mult7 (multiples 7) :when (.contains "05" (subs mult7 1 2))
		  mult17 (multiples 17)]
	      (let [curr (str mult2 mult7 mult17) curr-set (set (seq curr))]
		(if (not= 9 (count curr-set))
		  0
		  (let [num (str (first (difference digits curr-set)) curr)]
		    (if (and (div-by? num 2 3) (div-by? num 5 11) (div-by? num 6 13))
		      (BigInteger. num)
		      0))))))))

