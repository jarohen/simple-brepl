(ns simple-brepl.client
  (:require [weasel.repl :as ws-repl]))

(when-let [repl-ip js/simple_brepl_ip]
  (when-let [repl-port js/simple_brepl_port]
    (ws-repl/connect (str "ws://" repl-ip ":" repl-port))))

