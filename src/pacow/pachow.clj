(ns pacow.pachow)

(def hards ["p" "ch" "k" "t" "w" "z" "m"])
(def vowels ["i" "o" "a"])

(defn generate
  ([max-syllables]
    (let [syllables (inc (rand-int max-syllables))
          last-hard (rand-nth hards)
          hards (repeatedly syllables #(rand-nth hards))
          vowels (repeatedly syllables #(rand-nth vowels))
          pachow (clojure.string/join (doall (map #(str %1 %2) hards vowels)))]
      (str pachow last-hard "ow")))
  ([]
    (generate 5)))
