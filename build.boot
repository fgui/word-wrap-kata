(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [adzerk/boot-test "1.0.4" :scope "test"]]
 )

(require '[adzerk.boot-test :refer :all])

(deftask testing
  "Profile setup for running tests."
  []
  (set-env! :source-paths #(conj % "test"))
  identity)

(task-options! repl {:eval '(set! *print-length* 20)})
