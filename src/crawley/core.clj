(ns crawley.core
   (:gen-class)
  (:use [crawley.client] [crawley.http] )

)



(defn -main []

(say-hi)


;main loop
(while (not= (str @command) (str "exit")) 
  (do 
   (ask-for-input)
   (get-command-code)
   (case (str @command-code)
    "get" (get-url @command)
    ("exit" "quit") (do (println "Bye bye! Comeback soon!") (reset! command "exit"))
    (println "Error, unrecognized command...")
   )
   (println (str "Last input: " @command))


  )
)
)
