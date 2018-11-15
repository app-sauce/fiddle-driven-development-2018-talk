(ns fiddle.start
  (:require
    [fiddle.lib :refer :all]))

#_(+ 1 1)
#_(/ 1 3)

(defn grid
  [size element]
  (into [] (repeat size (into [] (repeat size element)))))

#_(grid 20 0)

#_(millis->local-date (System/currentTimeMillis))
