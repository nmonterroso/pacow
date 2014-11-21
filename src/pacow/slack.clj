(ns pacow.slack
  (:require [clojure.data.json :as json]
            [environ.core :refer [env]]
            [org.httpkit.client :as http]))

(def endpoint (env :slack-endpoint))

(defn message [m post-params]
  (let [payload (json/write-str {:text m
                                 :channel (str "#" (:channel_name post-params))
                                 :username "cowsay"
                                 :icon_emoji ":cow:"})]
    (http/post endpoint {:form-params {:payload payload}})))
