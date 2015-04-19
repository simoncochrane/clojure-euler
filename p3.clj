(defn div? [n d]
  (= 0 (rem n d)))
 
(defn largest-prime-factor [number]
  (loop [n number d 2]
    (cond (> d (int (Math/sqrt number))) n
      (= n d) n
      (div? n d) (recur (/ n d) d)
      true (recur n (inc d)))))
 
(largest-prime-factor 600851475143)


(defn factor? [nr fctr]
  (zero? (rem nr fctr)))
 
(defn factorize
  ([nr]
    (if (factor? nr 2)
      (factorize nr (int (Math/sqrt nr)) 2 '[])
      (factorize nr (int (Math/sqrt nr)) 3 '[])))
   ([nr max-fac fac facs]
    (cond
      (> fac max-fac)  (conj facs nr)
      (= nr fac)       (conj facs fac)
      (factor? nr fac) (recur (/ nr fac) max-fac fac (conj facs fac))
      true             (recur nr (int (Math/sqrt nr)) (inc fac) facs))))
 
(defn euler-3 [nr]
  (apply max (factorize nr)))

;;;;;;;;;;;;;;;;;;;;;

(filter #(not= (largest-prime-factor %) (euler-3 %)) (range 100000 1000000))

(filter #(> (largest-prime-factor %) (int (Math/sqrt %))) (range 1 100000))


