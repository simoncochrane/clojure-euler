(use 'clojure.contrib.duck-streams)

(def triangle-nums
     (map #(int (* 0.5 % (inc %))) (iterate inc 1)))

(defn triangle-num? [x]
  (= x (some #(if (>= % x) % nil) triangle-nums)))

(defn words [filename]
   (map #(second %) (re-seq #"\"(\w+)\",?" (slurp filename))))

(defn eul42 [filename]
  (count (filter triangle-num? 
		 (map #(- (reduce + (map int (seq %))) (* 64 (count %)))
		      (words filename)))))
