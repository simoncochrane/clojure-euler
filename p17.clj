
(def tens ["" "" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])

(def nums ["" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine" "ten"
	   "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen"
	   "eighteen" "nineteen"])

(defn num-to-word [num]
  (cond (= num 1000) "one thousand"
	(>= num 100) (str (num-to-word (int (/ num 100)))
			  " hundred"
			  (if (zero? (mod num 100)) ""
			      (str " and " (num-to-word (mod num 100)))))
	(>= num 20) (str (nth tens (int (/ num 10)))
			 (if (zero? (mod num 10)) ""
				    (str " " (num-to-word (mod num 10)))))
	(> num 0) (nth nums num)))

(reduce + (map #(count (filter (fn [char] (not= char \space)) (num-to-word %)))
	       (range 1 1001)))