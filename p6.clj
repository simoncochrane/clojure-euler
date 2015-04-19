
(defn eul6 [upto]
  (- (Math/pow (reduce + (range 1 (inc upto))) 2)
     (reduce + (map #(Math/pow % 2) (range 1 (inc upto))))))
