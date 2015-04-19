(import '(java.math BigInteger))

(defn pows [num upto]
  (map #(.pow (BigInteger/valueOf num) %) (range 2 (inc upto))))

(defn eul29 [upto]
  (count (reduce into #{} (map #(pows % upto) (range 2 (inc upto))))))
