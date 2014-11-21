(ns pacow.core
  (:require [pacow.server :as server]))

(defn -main [&args]
  (server/start))
