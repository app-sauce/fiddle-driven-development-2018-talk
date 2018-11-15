(ns fiddle.tictac
  (:require
    [app.tictac :as tictac]
    [fiddle.lib :refer :all]))

;; Coded during the talk

#_(-> tictac/initial-game
      (tictac/play 1 1)
      (tictac/play 2 2)
      :board
      )

#_(-> tictac/initial-game
      (tictac/play 0 0)
      (tictac/play 2 2)
      (tictac/play 2 1)
      (tictac/print)
      )

#_(-> tictac/initial-game
      (tictac/play 0 0)
      (tictac/play 2 2)
      (tictac/play 2 1)
      (tictac/print)
      )
