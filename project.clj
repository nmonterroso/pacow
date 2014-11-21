(defproject pacow "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.2.1"]
                 [environ "0.5.0"]
                 [http-kit "2.1.16"]
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.5"]
                 [ring "1.3.0"]]
  :profiles  {:dev  {:source-paths  ["dev"]}}
  :main pacow.core
  :aot [pacow.core]
  :repl-options {:init-ns user}
  :uberjar-name "pacow-standalone.jar"
  :jvm-opts ["-server"])
