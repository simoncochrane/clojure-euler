(use 'clojure.contrib.lazy-seqs)

(defn prime? [num]
  (let [sq (Math/sqrt num)]
    (nil? (some #(zero? (rem num %1)) (take-while #(< %1 sq) primes)))))

(defn max-num-prime-family [num positions]
  (let [num-str (str num)]
    (reduce + (map #(if (and (prime? (Integer/parseInt %1)) (not= "0" (subs %1 0 1)))
;    (reduce + (map #(if (prime? (Integer/parseInt %1))
		      1
		      0)
		   (for [digit (range 0 10)]
		     (apply str
			    (for [pos (range 0 (count num-str))]
			      (if (contains? positions pos)
				digit
				(subs num-str pos (inc pos))))))))))

(defn max-num-prime-family-recurse [num positions]
  (let [cnt (count (str num))]
    (loop [i 0 pos positions mx 0]
      (if (or (>= (inc (count pos)) cnt) (>= (inc i) cnt))
	mx
	(if (contains? pos i)
	  (recur (inc i) pos mx)
;	  (do (println "i=" i (conj pos i) "n=" (max-num-prime-family num (conj pos i)))
	      (let [mx (max mx (max-num-prime-family-recurse num (conj pos i)))]
		(recur (inc i)
		       pos
		       (max mx (max-num-prime-family num (conj pos i))))))))))

(defn eul51[num-primes]
  (some #(if (<= num-primes (max-num-prime-family-recurse %1 #{})) %1 nil) primes))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



			
		      
  



