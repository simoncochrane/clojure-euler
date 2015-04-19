(use 'clojure.contrib.math)

(defn pyth-perimeters [hypotenuse]
  (let [hyp-sq (* hypotenuse hypotenuse)]
    (sort (distinct 
	   (map #(+ hypotenuse % (sqrt (- hyp-sq (* % %))))
		(filter #(zero? (second (exact-integer-sqrt (- hyp-sq (* % %)))))
			(range 1 hypotenuse)))))))

(defn add-perims [perimeters perims-map]
  (loop [perims perimeters pmap perims-map]
    (if (and (first perims) (< (first perims) 1000))
      (let [p (first perims)
	    cnt (if (contains? pmap p) (inc (get pmap p)) 1)]
	(recur (rest perims) (assoc pmap p cnt)))
      pmap)))
      
(defn eul39 []
  (loop [i 1 perims {}]
    (if (= i 1000)
      (let [max-sols (apply max (vals perims))]
	(some #(if (= (val %) max-sols) (key %) nil) perims))
      (recur (inc i) (add-perims (pyth-perimeters i) perims)))))

;;;
; TODO: Understand this solution:

(defn limit [p]
  (int (/ (* (- 2 (Math/sqrt 2)) p) 2)))
 
(defn solve [a p]
  (/ (- (* p p) (* 2 a p)) (* 2 (- p a))))
 
(defn euler-39
  ([]
     (euler-39 1000))
  ([n]
     (loop [p 1 a 1 lima (limit p) maxp 0 maxn 0 hits 0]
       (if (> p n)
         [maxp maxn]
         (if (> a lima)
           (let [p1+ (inc p) test (> hits maxn)]
             (recur p1+ 1 (limit p1+) (if test p maxp)
                    (if test hits maxn) 0))
           (recur p (inc a) lima maxp maxn 
		  (if (integer? (solve a p)) (inc hits) hits)))))))
