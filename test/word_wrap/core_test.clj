(ns word-wrap.core-test
  (:require [clojure.test :refer :all]
            [word-wrap.core :refer :all]))

(deftest a-wrapper
  (testing "simple test on line" (is (= "hola" (wrap "hola" 5)))))
