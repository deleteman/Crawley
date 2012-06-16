(ns crawley.http  
  (:require [net.cgrand.enlive-html :as html] [crawley.io :as io])
)
(use '[clojure.string :only (split)])
  
(defn correct-url [url]
  "Turns a url into a valid one (basically, adds http:// if it doens't have it already"
  (if (nil? (re-find #"http://" url))
    (str "http://" url)
    url
    )
)

(defn get-domain-from-url [url]
  "Extracts the domain name from a url"
  (first (split (clojure.string/replace url #"http://" "") #"/"))
)

(defn get-filename-from-url [url]
  (let [fname (last (split url #"/"))]
    (if (clojure.string/blank? fname)
      "index.html"
      fname)
    )
)

(defn get-url [command-line]
  "Gets the URL and saves it's content inside a folder with the same domain name"
  (let [parts (split command-line #" ") 
        url (correct-url (second parts))
        folder-name (str "./" (str (get-domain-from-url url)))]

   (io/create-folder (str folder-name "/a"))

   (let [str_response (html/html-resource (java.net.URL. url))]
     (io/write-file (str folder-name "/" (get-filename-from-url url)) str_response)

     (println (map #(-> % :attrs :href) (html/select str_response [:a])))
    ) 
  )
)