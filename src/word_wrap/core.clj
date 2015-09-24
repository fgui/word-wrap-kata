(ns word-wrap.core)

(defn lines
  "Splits into lines which are shorter than column.
  Should respect original split of lines.
  "
  [^String text ^long column]
  (clojure.string/split text #"\n"))

(defn wrap
  "The function returns the string, but with line breaks inserted at just
  the right places to make sure that no line is longer than the column number.
  Ttry to break lines at word boundaries.
  Like a word processor, break the line by replacing the last space ine
  a line with a newline."
  [^String text ^long column]
  (clojure.string/join \newline (lines text)))
