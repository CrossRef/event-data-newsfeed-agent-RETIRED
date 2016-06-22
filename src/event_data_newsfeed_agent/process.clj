(ns event-data-newsfeed-agent.process
  "Process feed entries."
  (:require [baleen.queue :as baleen-queue]
            [baleen.web :as baleen-web]
            [baleen.util :as baleen-util])
  (:require [clojure.data.json :as json]
            [clojure.tools.logging :as l]
            [clojure.set :refer [difference]]))

(defn events-from-entry
  "Process a new input event by looking up old and new revisions.
  Return map in audit log format, with :input, :events and :meta."
  [context json-blob]
  
  (let [data (json/read-str json-blob)
        {title "title"
        link "link"
        id "id"
        updated "updated"
        summary "summary"
        feed-url "feed-url"
        fetch-date "fetch-date"} data

        dois (baleen-web/extract-dois-from-body summary)

        ; The link for Feedburner is behind a redirect which is annoying.
        ; However feedburner do use the URL as the id (which isn't standard behaviour).
        ; Links for Inoreader are fine.
        url (if (.contains link "feedproxy.google.com")
                          id
                          link)

        events (map (fn [doi] {:doi doi :event-id (baleen-util/new-uuid)}) dois)]

    {:input data
     :events events
     ; save the URL because it was derived.
     :meta {:url url}}))

(defn process-f
  [context json-blob]
  (let [results (events-from-entry context json-blob)
        result-str (json/write-str results)]
    (l/info "Process, results:" results)
        (if results
          (do
            (baleen-queue/enqueue context "matched" result-str true)
            true)

          (do 
            (baleen-queue/enqueue context "unmatched" result-str true)
            true))))

(defn run
  "Run processing. Blocks forever."
  [context]
  (l/info "Run process.")
  (baleen-queue/process-queue context "input" (partial process-f context)))
