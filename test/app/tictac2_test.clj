(ns app.tictac2-test
  (:require
   [clojure.test :refer [deftest is]]
   [app.tictac2 :refer :all]))

;; Reference code

(deftest win
  (is (= "O"
         (-> initial
             (play 1 1)
             (play 0 0)
             (play 2 1)
             (play 0 1)
             (play 2 2)
             (play 0 2)
             game-winner
             ))))

