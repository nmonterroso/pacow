(ns pacow.cowsay
  (:require [clojure.java.shell :refer [sh]]
            [environ.core :refer [env]]))

(def cowsay (env :cowsay-bin "cowsay"))

(defn slack-out [text]
  (str "```" text "```"))

(defn animalsay [animal message]
  (:out (sh cowsay "-f" animal message)))

(defn moo [message]
  (:out (sh cowsay message)))

(defn handle-cowsay [text]
  (let [[_ animal message] (re-find #"^\-f (.*?) (.*)" text)]
    (if animal
      (slack-out (animalsay animal message))
      (slack-out (moo text))
    )
  )
)
