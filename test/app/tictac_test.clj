(ns app.tictac-test
  (:require
   [clojure.test :refer [deftest is]]
   [app.tictac :refer :all]))

(deftest simple
  (is (= 1 1)))

