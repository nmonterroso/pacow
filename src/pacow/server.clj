(ns pacow.server
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [not-found]]
            [environ.core :refer [env]]
            [pacow.cowsay :as cowsay]
            [pacow.pachow :as pachow]
            [pacow.slack :as slack]
            [org.httpkit.server :refer :all]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.multipart-params :refer :all]
            [ring.util.response :refer [header]]))

(defn form-params->params [params]
  (reduce (fn [running [key val]]
            (assoc running (keyword key) val))
          {} params))

(def empty-response "")

(defn response-headers [handler]
  (fn [request]
    (-> (handler request)
        (header "Connection" "close"))))

(defroutes routes
           (POST "/slack/pacow" request
                 (let [post-params (form-params->params (:form-params request))]
                   (slack/message (cowsay/moo (pachow/generate)) post-params))
                 empty-response)
           (POST "/slack/cowsay" request
                 (let [post-params (form-params->params (:form-params request))
                       message (:text post-params)]
                   (slack/message (cowsay/moo message) post-params))
                 empty-response)
           (POST "/slack/pachow" request
                 (let [post-params (form-params->params (:form-params request))]
                   (slack/message (pachow/generate) post-params))
                 empty-response))

(defn start
  ([port]
    (let [site (-> (site #'routes)
                   response-headers)]
      (run-server site {:port (Integer/parseInt port)})))
  ([]
    (start (env :server-port 8080))))
