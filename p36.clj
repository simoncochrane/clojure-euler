
(def palindromes
     (concat [1 2 3 4 5 6 7 8 9]
	     (filter #(< % 1000000)
		     (for [outer (range 1 1000) digit (range -1 10)]
		       (Integer/parseInt
			(str outer
			     (if (>= digit 0) digit "")
			     (apply str (reverse (str outer)))))))))

(defn bin-palindrome? [num]
  (let [bin (Integer/toBinaryString num) reverse (apply str (reverse bin))]
    (= bin reverse)))

(defn eul36 []
  (reduce + (filter bin-palindrome? palindromes)))

