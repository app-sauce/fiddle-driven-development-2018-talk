# Fiddle Driven Development 2018 Talk

This repository contains supporting code used during the Los Angeles Clojure
Meetup on November 14th, 2018.

# To try out Fiddle Driven Development

This assumes you are running a connected editor.

1. Run a REPL in one terminal
1. Launch Vim (or another editor) in another terminal
1. Open a window with application code (e.g. `src/app/tictac2.clj`)
1. Open a split with the corresponding fiddle (e.g. `dev/fiddle/tictac2.clj`)
1. Run the various functions in the fiddle to execute application code and inspect the results

# Interesting files:

```
# Commonly useful fiddle functions
dev/fiddle/lib.clj

# Files edited during the tic tac toe portion of the demo
dev/fiddle/tictac.clj
src/app/tictac.clj
test/app/tictac_test.clj

# Reference implementation, with more code and fiddle
dev/fiddle/tictac2.clj
src/app/tictac2.clj
test/app/tictac2_test.clj

# Twitter fiddle code
dev/fiddle/twitter.clj
```
