(ns word-wrap.core)

(defn break-line [^String line ^long column]
  (if (<= (count line) column)
    (if (empty? line) [] [line])
    (let [last-space (.lastIndexOf (apply str (take (inc column) line)) " ")
          end-line (if (pos? last-space) last-space column)
          start-new-line (if (pos? last-space) (inc last-space) column)]
      (cons
       (apply str (take end-line line))
       (break-line (apply str (drop start-new-line line)) column)))))

(defn text->lines [^String text ^long column]
  (flatten (map #(break-line % column) (clojure.string/split text #"\n"))))

(defn wrap [^String text ^long column]
  (clojure.string/join \newline (text->lines text column)))
