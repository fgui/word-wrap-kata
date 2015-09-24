(ns word-wrap.core)

(defn break-line [line column]
  (if (empty? line)
    []
    (cons
     (apply str (take column line))
     (break-line (drop column line) column))))

(defn lines
  [^String text ^long column]
  (flatten (map #(break-line % column) (clojure.string/split text #"\n"))))

(defn wrap
  [^String text ^long column]
  (clojure.string/join \newline (lines text column)))
