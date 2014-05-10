(ns simple-brepl.client
  (:require [weasel.repl :as ws-repl]))

(when-let [repl-port js/simple_brepl_port]
  (ws-repl/connect (str "ws://" js/location.hostname ":" repl-port)))
