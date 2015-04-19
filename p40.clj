(use 'clojure.contrib.seq-utils)

(def pos-ints
  (map #(- (int %) 48) (flatten (map #(split-at 1 (str %)) (iterate inc 1)))))

(defn eul40
  ([n] (nth pos-ints (dec n)))
  ([n & more] (* (eul40 n) (apply eul40 more))))

(eul40 1 10 100 1000 10000 100000 1000000)

