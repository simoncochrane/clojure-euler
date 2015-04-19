
(defn diagonals []
  (map first (iterate
	      (fn [[val size]] 
		(let [nval (+ val size 1) nsize (+ size 2)]
		  (if (= nval (* nsize nsize))
		    [nval nsize]
		    [nval size]))) [1 1])))

(defn sum-diagonals [size]
  (reduce + (take (inc (* 4 (int (/ size 2)))) (diagonals))))

(sum-diagonals 1001)
