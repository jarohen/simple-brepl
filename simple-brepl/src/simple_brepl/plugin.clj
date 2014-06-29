(ns simple-brepl.plugin
  (:require [clojure.java.io :as io]
            [robert.hooke :refer [add-hook]]
            [leiningen.core.eval :as eval]))

(defn with-core-dep [project]
  (update-in project [:dependencies]
             conj
             ['jarohen/simple-brepl-core (slurp (io/resource "simple_brepl/VERSION"))]))

(defn with-piggieback-hook [project]
  (-> project
      (update-in [:repl-options :nrepl-middleware] conj 'cemerick.piggieback/wrap-cljs-repl)))

(defn middleware [project]
  (-> project
      with-core-dep
      with-piggieback-hook))

(defn wrap-eval [eval-in-project project form & [init]]
  (let [{{:keys [ip port]
          :or {ip "127.0.0.1" port 9001}} :brepl} project]
    
    (eval-in-project project

                     `(do
                        (simple-brepl.service/load-brepl! ~ip ~port)
                        ~form)
       
                     `(do
                        (require 'simple-brepl.service)
                        ~init))))

(defn hooks []
  (add-hook #'eval/eval-in-project #'wrap-eval))
