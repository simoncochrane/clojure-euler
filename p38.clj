
(defn pandigital? [num-str]
  (and (= (count num-str) 9)
       (= (apply str (sort num-str)) "123456789")))

(defn concat-product [num n]
  (apply str (map #(* num %) (range 1 (inc n)))))

(defn max-concat-product [num]
  (loop [n 2 max 0]
    (let [cp-str (concat-product num n)
	  cp (if (> (count cp-str) 9) Integer/MAX_VALUE (Integer/parseInt cp-str))]
      (cond (> cp 987654321) max
	    (and (pandigital? cp-str) (> cp max)) (recur (inc n) cp)
	    :else (recur (inc n) max)))))

(defn eul38 []
  (apply max (map max-concat-product (range 1 10000))))
      

  

