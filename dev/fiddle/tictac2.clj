(ns fiddle.tictac2
  (:require
    [app.tictac2 :as tictac]
    [fiddle.lib :refer :all]))

;; Reference code

#_(-> tictac/initial)

#_(tictac/print-game tictac/initial)

#_(tictac/row->str [" " " " "X"])
#_(tictac/row->str ["O" " " "X"])
#_(tictac/row->str ["X" "O" "O"])

#_(tictac/play->str [0 2 "X"])
#_(tictac/play->str [1 1 "O"])

#_(tictac/diag? 1 1)
#_(tictac/diag? 2 1)
#_(tictac/rdiag? 0 2)
#_(tictac/rdiag? 1 2)

#_(-> tictac/initial-tracking
      (tictac/add-tracking 1 1 "X"))

#_(-> tictac/initial
      (tictac/play 1 1)
      (tictac/play 0 0)
      (tictac/play 2 1)
      (tictac/play 0 1)
      (tictac/play 2 2)
      (tictac/play 0 2)
      tictac/print-game
      ; tictac/game-winner
      )

#_(-> tictac/initial
      (tictac/play 0 0)
      (tictac/play 0 1)
      (tictac/play 1 1)
      (tictac/play 0 2)
      (tictac/play 2 2)
      tictac/print-game
      ; tictac/game-winner
      )
