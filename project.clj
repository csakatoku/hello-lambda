(defproject hellolambda "0.1.3-SNAPSHOT"
  :description "Hello AWS Lambda"
  :url "https://github.com/csakatoku/hello-lambda"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.6"]
                 [com.amazonaws/aws-lambda-java-core "1.0.0"]
                 [twitter-api "0.7.8"]]
  :aot :all)
