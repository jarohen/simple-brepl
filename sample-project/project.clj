(defproject sample-project ""

  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[org.clojure/clojure "1.6.0"]

                 [ring/ring-core "1.2.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]

                 [prismatic/dommy "0.1.2"]
                 
                 [org.clojure/clojurescript "0.0-2261"]]

  :plugins [[jarohen/lein-frodo "0.3.2"]
            [jarohen/simple-brepl "0.1.1"]
            [lein-cljsbuild "1.0.3"]
            [lein-shell "0.4.0"]

            [lein-pdo "0.1.1"]]

  :frodo/config-resource "sample-project-config.edn"

  :source-paths ["src/clojure"]

  :resource-paths ["resources" "target/resources"]

  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :jar true
                        :compiler {:output-to "target/resources/js/sample-project.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}

  :brepl {:ip "127.0.0.1" :port 9001}

  :aliases {"dev" ["do"
                   ["shell" "mkdir" "-p"
                    "target/resources"]
                   ["pdo"
                    ["cljsbuild" "auto"]
                    "frodo"]]})

