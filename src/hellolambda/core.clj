(ns hellolambda.core
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.java.io :as io]
            [cheshire.core :as cheshire]))

(defn hello [params]
  {:message (str "Hello " (:name params))})

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (-> (cheshire/parse-stream (io/reader is) true)
        (hello)
        (cheshire/generate-stream w))
    (.flush w)))
