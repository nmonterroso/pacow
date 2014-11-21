(ns pacow.cowsay
  (:require [clojure.java.shell :refer [sh]]
            [environ.core :refer [env]]))

(def bin (env :cowsay-bin "cowsay"))

(defn moo [m]
  (let [out (:out (sh bin m))]
    (str "```" out "```")))
