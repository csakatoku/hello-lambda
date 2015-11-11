(ns hellolambda.tweet
  (:gen-class
   :methods [^:static [handler [String] String]])
  (:require [twitter.oauth :as oauth]
            [twitter.api.restful :as restapi]))

(def my-creds (oauth/make-oauth-creds "CONSUMER_KEY"
                                      "CONSUMER_SECRET"
                                      "ACCESS_TOKEN"
                                      "ACCESS_TOKEN_SECRET"))

(defn -handler [status]
  (get-in (restapi/statuses-update :oauth-creds my-creds
                                   :params {:status status})
          [:body :id_str]))
