(ns event-data-newsfeed-agent.core
  (:require [clojure.tools.logging :as l])
  (:require [event-data-newsfeed-agent.feeds :as feeds]
            [event-data-newsfeed-agent.process :as process]
            [event-data-newsfeed-agent.push :as push])
  (:require [baleen.context :as baleen]
            [baleen.monitor :as baleen-monitor])
  (:require [clj-time.core :as clj-time]
            [clj-time.format :as clj-time-format])
  (:gen-class))

(defn main-enqueue [context]
  (l/info "Enqueue...")
  (feeds/queue-all context)
  (l/info "Done"))


(defn main-process [context]
  (l/info "Process")
  (baleen-monitor/register-heartbeat context "process")
  (process/run context))


(defn main-push [context]
  (l/info "Push")
  (baleen-monitor/register-heartbeat context "push")
  (push/run context))

; (defn main-archive [context]
;   ; TODO
;   (l/info "Archive"))

(defn main-monitor [context]
  (l/info "Monitor")
  (baleen-monitor/register-heartbeat context "monitor")
  (baleen-monitor/run context))

(defn main-add [context feed-url]
  (l/info "Add" feed-url)
  (feeds/add-feed context feed-url))


(defn main-unrecognised-action
  [command]
  (l/fatal "ERROR didn't recognise " command))

(defn -main
  [& args]
  (let [context (baleen/->Context
                  "newsfeed"
                  "Newsfeed Event Data Agent"
                  #{})

        command (first args)]

    (baleen/boot! context)

    (condp = command
      "add-feed" (main-add context (second args))
      "enqueue" (main-enqueue context)
      ; "ingest" (main-ingest context)
      "process" (main-process context)
      "push" (main-push context)
      ; "archive" (main-archive context)
      "monitor" (main-monitor context)
      (main-unrecognised-action command))))
