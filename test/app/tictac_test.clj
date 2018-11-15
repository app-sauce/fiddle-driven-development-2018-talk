(ns app.tictac-test
  (:require
   [clojure.test :refer [deftest is]]
   [app.tictac :refer :all]))

;; Coded during the talk

(deftest simple
  (is (= [[" " " " " "] [" " "X" " "] [" " " " "O"]]
         (-> initial-game
             (play 1 1)
             (play 2 2)
             :board
             ))))

