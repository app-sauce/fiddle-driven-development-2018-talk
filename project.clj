(defproject la-clojure-meetup-fiddle-driven-development-2018 "0.1.0-SNAPSHOT"
  :description "Demo source for the Fiddle Driven Development talk at the LA Clojure Meetup"
  :url "TODO"
  :license {:name "MIT"}
  :dependencies
  [[org.clojure/clojure "1.8.0"]
   [com.stuartsierra/component "0.3.2"]
   [twttr "3.2.0"]]
  :profiles
  {:dev
   {:dependencies
    [[org.clojure/tools.namespace "0.2.11"]
     [com.stuartsierra/component.repl "0.2.0"]]
    :source-paths
    ["dev"]}})
