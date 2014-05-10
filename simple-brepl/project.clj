(defproject jarohen/simple-brepl (slurp (clojure.java.io/file "../resources/simple_brepl/VERSION"))
  :description "A plugin to make opening a CLJS browser REPL simple, based atop Weasel"
  :url "https://github.com/james-henderson/simple-brepl"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[leinjacker "0.4.2"]]
  
  :eval-in-leiningen true

  :scm {:dir ".."}

  :resource-paths ["resources" "../resources"])
