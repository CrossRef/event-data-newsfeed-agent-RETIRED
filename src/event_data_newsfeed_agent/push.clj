(ns event-data-newsfeed-agent.push
  "Push events to Lagotto."
  (:require [baleen.queue :as baleen-queue]
            [baleen.web :as baleen-web]
            [baleen.util :as baleen-util]
            [baleen.lagotto :as baleen-lagotto])
  (:require [clojure.data.json :as json]
            [clojure.tools.logging :as l]
            [clojure.set :refer [difference]])
  (:require [clj-time.coerce :as clj-time-coerce]))

(defn process-f [context json-blob]
  (let [item-parsed (json/read-str json-blob)
        input (get item-parsed "input")
        events (get-in item-parsed ["events"])

        timestamp (str (clj-time-coerce/from-string (get-in item-parsed ["input" "updated"])))

        title (get-in item-parsed ["input" "title"])
        
        url (get-in item-parsed ["meta" "url"])
          
        results (doall (map (fn [{doi "doi" event-id "event-id"}]
                                  (baleen-lagotto/send-deposit
                                    context
                                    :subj-title title
                                    :subj-url url
                                    :subj-work-type "post-weblog"
                                    :obj-doi doi
                                    :action "add"
                                    :event-id event-id
                                    :date-str timestamp
                                    :source-id "newsfeed"
                                    :relation-type "discusses")) events))

       ]
      ; Return success.
      (every? true? results)))

(defn run
  "Run processing. Blocks forever."
  [context]
  (baleen-queue/process-queue context "matched" (partial process-f context) :keep-done true))

