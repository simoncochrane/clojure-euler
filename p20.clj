
(defn fact [x]
  (reduce * (range 1 (inc x))))

(reduce + (map #(- (int %) 48) (seq (str (fact 100)))))


