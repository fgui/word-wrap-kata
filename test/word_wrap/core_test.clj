 (ns word-wrap.core-test
  (:require [clojure.test :refer :all]
            [word-wrap.core :refer :all]))

(deftest wrap-test
  (testing "simple test on line"
    (is (= "hola" (wrap "hola" 5)))
    (is (= "hola" (wrap "hola" 4))))
  (testing "multi-line ok" (is (= "hola\nadeu" (wrap "hola\nadeu" 4))))
  (testing "split no space" (is (= "hola\nadeu" (wrap "holaadeu" 4))))
  (testing "split w space" (is (= "hola\nadeu" (wrap "hola adeu" 4))))
  (testing "split on a space" (is (= "hola\nadeu" (wrap "hola adeu" 6))))
  (testing "split 3 times" (is (= "hola\nadeu\nbyebye"
                                  (wrap "hola adeu byebye" 6))))
  (testing "keep a space" (is (= "ho la\nadeu\nbyebye"
                                 (wrap "ho la adeu byebye" 6)))))
