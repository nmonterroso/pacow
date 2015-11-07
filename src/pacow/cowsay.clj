(ns pacow.cowsay
  (:require [clojure.java.shell :refer [sh]]
            [environ.core :refer [env]]))

(def cowsay (env :cowsay-bin "cowsay"))

(defn animalsay [animal message]
  (:out (sh cowsay "-f" animal message)))

(defn moo [message]
  (:out (sh cowsay message)))

(defn handle-cowsay [text]
  (let [[_ animal message] (re-find #"^\-animal (.*?) (.*)" text)]
    (if animal
      (animalsay animal message)
      (moo text)
    )
  )
)
