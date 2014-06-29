(ns ^{:clojure.tools.namespace.repl/load false
      :clojure.tools.namespace.repl/unload false}
  simple-brepl.service

  (:require [cemerick.piggieback :as p]
            [weasel.repl.websocket :as ws-repl]
            [weasel.repl.server :as ws-server]))

(def ^:private !brepl-config
  (atom {}))

(defn load-brepl! [ip port]
  (reset! !brepl-config {:ip ip :port port})
  (intern 'user 'simple-brepl
          (fn []
            (p/cljs-repl :repl-env (ws-repl/repl-env :ip ip :port port)))))
 
(defn brepl-open? []
  ;; Admittedly, this is quite a hack to decide whether the WS is
  ;; open...
  (boolean (:server @ws-server/state)))

(defn- wrap-quotes [s]
  (when s
    (str \" s \")))

(defn brepl-js []
  (apply format "window.simple_brepl_ip=%s;window.simple_brepl_port=%d;"
    (if (brepl-open?)
      ((juxt (comp wrap-quotes :ip) :port) @!brepl-config)
      [nil nil])))
