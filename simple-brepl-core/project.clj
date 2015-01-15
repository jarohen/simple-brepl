(defproject jarohen/simple-brepl-core (.trim (slurp (clojure.java.io/file "../resources/simple_brepl/VERSION")))
  :description "Functionality for simple-brepl plugin to call"
  :url "https://github.com/james-henderson/simple-brepl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [weasel "0.5.0"]
                 [com.cemerick/piggieback "0.1.5"]
                 [org.clojure/clojurescript "0.0-2665"]]

  :scm {:dir ".."}

  :resource-paths ["resources" "../resources"])
