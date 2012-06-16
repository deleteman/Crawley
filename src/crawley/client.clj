(ns crawley.client)
(use '[clojure.string :only (split)])


(def command (atom ""))
(def command-code (atom "none"))

(defn say-hi []
  (println "Hi there! Welcome to Crawley")
)

(defn print-prompt []
  (print "Crawley> ")
  (flush)
)

(defn ask-for-input []
    (print-prompt)
    (let [x (str (read-line))]
      (println (str "User input: " x))
      (reset! command x)
    )
)

(defn get-command-code []
  (let [parts (split @command #" ")]
    (reset! command-code (first parts))
  )
)