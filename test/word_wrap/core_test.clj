 (ns word-wrap.core-test
  (:require [clojure.test :refer :all]
            [word-wrap.core :refer :all]))

(deftest wrap-test
  (testing "simple test on line"
    (is (= "hola" (wrap "hola" 5)))
    (is (= "hola" (wrap "hola" 3))))
  (testing "multi-line ok"
    (is (= "hola\nadeu" (wrap "hola\nadeu" 4))))
  )
