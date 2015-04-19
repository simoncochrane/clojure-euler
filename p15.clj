
;; returns all steps (but runs out of memory)

(defn step [x y grid-size direction]
   (map #(if direction (cons direction %) %)
        (if (= x y grid-size)
          ['()]
          (concat
           (cond (< x grid-size) (step (inc x) y grid-size :right)
                 :true nil)
           (cond (< y grid-size) (step x (inc y) grid-size :down)
                 :true nil)))))

(defn euler15 [size]
 (count (step 0 0 size nil)))

;; too slow

(defn step-count-slow [x y grid-size num-routes]
 (if (= x y grid-size)
   (inc num-routes)
   (do
     (let [num-routes (if (< x grid-size) (step-count-slow (inc x) y
grid-size num-routes) num-routes)]
       (if (< y grid-size) (step-count-slow x (inc y) grid-size
num-routes) num-routes)))))

(defn euler15-count-slow [size]
 (step-count-slow 0 0 size 0))

;;

(defn step-count [x y grid-size num-routes]
 (if (= x y grid-size)
   (inc num-routes)
   (do
     (let [num-routes (if (< x grid-size) (step-count (inc x) y
grid-size num-routes) num-routes)]
       (if (< y grid-size)
         (recur x (inc y) grid-size num-routes)
         num-routes)))))

(defn euler15-count [size]
 (step-count 0 0 size 0))

