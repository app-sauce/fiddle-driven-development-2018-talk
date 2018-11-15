(ns app.tictac
  (:require
    [clojure.string :as string]))

;; Coded during the talk

(def initial-game
  {:board (into [] (repeat 3 (into [] (repeat 3 " "))))
   :next "X"})

(defn play
  [game row column]
  (let [player (:next game)
        next-player (if (= player "X") "O" "X")] (-> game
      (assoc-in [:board row column] player)
      (assoc :next next-player))))

(defn meetup
  [])

(defn print
  [game]
  (println "Board:")
  (run! #(println %) (:board game))
  (println "Next:" (:next game)))
