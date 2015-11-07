(ns pacow.slack
  (:require [clojure.data.json :as json]
            [environ.core :refer [env]]
            [org.httpkit.client :as http]))

(def endpoint (env :slack-endpoint))

(defn block-text [text]
  (str "```" text "```"))

(defn message
  ([m post-params] (message m post-params false))
  ([m post-params block-text?]
   (let [payload (json/write-str {:text (if block-text? (block-text m) m)
                                  :channel (str "#" (:channel_name post-params))
                                  :username "cowsay"
                                  :icon_emoji ":cow:"})]
     (http/post endpoint {:form-params {:payload payload}}))))

