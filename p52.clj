
(defn digits1 [num]
  (sort (map #(mod % 10) (take-while #(> % 0) (iterate #(quot % 10) num)))))

;; this is faster:
(defn digits2 [num]
  (sort (seq (str num))))

;;;;;;;;;;;;;

(defn contain-same-digits? [& nums]
  (let [f (sort (seq (str (first nums))))]
    (every? #(= f (sort (seq (str %)))) (rest nums))))

(defn multiples-upto [num upto]
  (map #(* num %) (range 1 (inc upto))))

(defn eul52 [upto]
  (some #(if (apply contain-same-digits? (multiples-upto % upto)) % nil)
	(filter #(contain-same-digits? % (* 2 %)) (iterate inc 1))))


