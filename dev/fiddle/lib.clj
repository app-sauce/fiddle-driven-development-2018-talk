(ns fiddle.lib
  (:require
    [clojure.pprint :refer [pprint]]
    [java-time :as t]
    )
  (:import [java.time OffsetDateTime]))

(defn pp
  [f]
  (pprint f))

(defmacro tp
  [body]
  `(try ~body
        (catch Exception e#
          (println e#))))

; https://stackoverflow.com/questions/47722004/clojure-macro-that-writes-try-blocks?rq=1
(defmacro t
  ([body]
   `(try ~body
      (catch Exception e#
        (str "caught exception: " e#))))
  ([bindings & body]
   `(try
      (with-open ~bindings
        ~@body)
      (catch Exception e#
        (str "caught exception: " e#)))))

(defn map-by
  [k coll]
  (reduce #(assoc %1 (k %2) %2) {} coll))

(defn map-by-id
  [coll]
  (map-by :id coll))

(defn date-str->millis
  [date-str]
  (-> (OffsetDateTime/parse date-str)
      .toInstant
      .toEpochMilli))

(defn millis->local-date
  [millis]
  (t/format "yyyy-MM-dd HH:mm:ss" (.atZone (t/instant millis) (t/zone-id "America/Los_Angeles"))))
