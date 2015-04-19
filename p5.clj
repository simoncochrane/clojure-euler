(defn multiple? [x]
  (empty? (filter (complement #(zero? (rem x %))) (range 20 10 -1))))

(loop [i (* 20 19)]
  (if (multiple? i) i
      (recur (+ i (* 20 19)))))
