(ns app.tictac2
  (:require
    [clojure.string :as string]))

;; Reference code

;; Printing

(defn row->str
  [row]
  (->> row
       (map #(str "[" % "]"))
       (string/join " ")))

(defn play->str
  [play]
  (let [[row column player] play]
    (str "* " player " played row " (inc row) " and column " (inc column))))

(defn print-game
  [game]
  (let [{:keys [board plays next winner]} game]
    (println "Board:")
    (run! #(println (row->str %)) board)
    (println "Next:" next)
    (println "Plays:")
    (run! #(println (play->str %)) plays)))


;; Win tracking

(defn winning-entry?
  [[_ count]]
  (= 3 count))

(defn entry->player
  [[[player _] count]]
  player)

(defn winner
  [tracking]
  (some-> (first (filter winning-entry? tracking))
          entry->player))

(defn record
  [tracking row column player]
  (-> tracking
      (update [player [:row row]] inc)
      (update [player [:column column]] inc)))

(defn record-diag
  [tracking player]
  (update tracking [player :diag] inc))

(defn record-rdiag
  [tracking player]
  (update tracking [player :rdiag] inc))

(defn diag?
  [row colum]
  (= row colum))

(defn rdiag?
  [row colum]
  (= 2 (+ row colum)))

(defn add-tracking
  [tracking row column player]
  (cond-> tracking
    true (record row column player)
    (diag? row column) (record-diag player)
    (rdiag? row column) (record-rdiag player)))

(def tracking-keys
  (for [player ["X" "O"]
        type (concat [:diag :rdiag]
                     (for [k [:row :column] i (range 3)] [k i]))]
    [player type]))

(def initial-tracking
  (reduce #(assoc %1 %2 0) {} tracking-keys))


;; Game actions

(def initial
  {:board (into [] (repeat 3 (into [] (repeat 3 " "))))
   :plays []
   :next "X"
   :tracking initial-tracking})

(defn game-winner
  [game]
  (winner (:tracking game)))

(defn play
  [game row column]
  (let [player (:next game)
        next (if (= player "X") "O" "X")]
    (-> game
        (assoc-in [:board row column] player)
        (update :plays conj [row column player])
        (assoc :next next)
        (update :tracking add-tracking row column player))))
