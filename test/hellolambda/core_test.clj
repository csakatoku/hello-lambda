(ns hellolambda.core-test
  (:require [clojure.test :refer :all]
            [hellolambda.core :refer :all]))

(deftest name-test
  (testing "hello should return a message 'Hello :name'"
    (is (= (:message (hello {:name "Lambda"})) "Hello Lambda"))))

(deftest empty-name-test
  (testing "hello should return a message 'Hello :name'"
    (is (= (:message (hello {})) "Hello "))))
