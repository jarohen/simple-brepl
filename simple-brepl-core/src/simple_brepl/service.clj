(ns ^{:clojure.tools.namespace.repl/load false
      :clojure.tools.namespace.repl/unload false}
  simple-brepl.service

  (:require [cemerick.piggieback :as p]
            [weasel.repl.websocket :as ws-repl]
            [weasel.repl.server :as ws-server]))

(def ^:private !brepl-port
  (atom nil))

(defn load-brepl! [brepl-port]
  (reset! !brepl-port brepl-port)
  (intern 'user 'simple-brepl
          (fn []
            (p/cljs-repl :repl-env (ws-repl/repl-env :port brepl-port)))))
 
(defn brepl-open? []
  ;; Admittedly, this is quite a hack to decide whether the WS is
  ;; open...
  (boolean (:channel @ws-server/state)))

(defn brepl-js []
  (format "window.simple_brepl_port=%d;"
          (when (brepl-open?)
            @!brepl-port)))
