(ns simple-brepl.client
  (:require [weasel.repl :as ws-repl]))

(when-let [repl-ip (.-simple_brepl_ip js/window)]
  (when-let [repl-port (.-simple_brepl_port js/window)]
    (ws-repl/connect (str "ws://" repl-ip ":" repl-port))))

