(ns fiddle.twitter
  (:require [twttr.api :as api]
            [twttr.auth :refer [->UserCredentials]]

            [fiddle.lib :refer :all]))

#_(def creds (->UserCredentials
               "xxxxxxxxxxxxxxxxxxxxxxxxx"
               "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
               "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
               "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))

(defn print-meta
  [data]
  (clojure.pprint/pprint (meta data))
  data)


#_(->> (api/statuses-user-timeline creds :params {:screen_name "ndj" :count 5})
       ; print-meta
       ; (map (juxt :id :text))
       ; (map #(select-keys % [:id :text]))
       )

#_(->> (api/statuses-home-timeline creds :params {:tweet_mode "extended" :count 20})
       print-meta
       (map :text))

#_(->> (api/statuses-sample creds)
       print-meta
       (filter :text)
       (take 10)
       (map :text))

#_(->> (api/saved-searches-list creds)
       print-meta)
#_(->> (api/saved-searches-show-id creds :params {:id "313782342"})
       print-meta)

#_(do
    (defn custom
      [data]
      (println "Meta:")
      (clojure.pprint/pprint (meta data))
      data)


    (->> (api/search-tweets creds :params {:q "#clojure"})
       custom
       :statuses
       (map :text)
       ))
