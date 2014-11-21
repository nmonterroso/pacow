(ns pacow.core
  (:require [pacow.server :as server])
  (:gen-class))

(defn -main [& args]
  (server/start))
