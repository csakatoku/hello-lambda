(ns hello_lambda.core
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.data.json :as json]
            [clojure.string :as s]
            [clojure.java.io :as io]))

(defn hello [params]
  {:message (str "Hello " (:name params))})

(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (-> (json/read (io/reader is) :key-fn keyword)
        (hello)
        (json/write w))
    (.flush w)))
