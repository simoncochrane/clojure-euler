
(defn factorial [x]
  (reduce * (range 2 (inc x))))

(defn nth-permutation [digits n]
  (loop [i 0 cnt 0]
    (if (= i (count digits)) nil
	(if (>= (+ cnt (factorial (dec (count digits)))) n)
	  (let [digit (subs digits i (inc i))]
	    (str digit (nth-permutation (.replace digits digit "") (- n cnt))))
	  (recur (inc i) (+ cnt (factorial (dec (count digits)))))))))

(nth-permutation "0123456789" 1000000)
    
  


