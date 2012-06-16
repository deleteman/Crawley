
(let [str_response (slurp "http://google.com")]
  (map #(println (str "Match: " %)) 
   (re-seq #"(?sm)href=\"([a-zA-Z.:/]+)\"" str_response))
