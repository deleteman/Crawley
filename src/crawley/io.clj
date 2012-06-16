(ns crawley.io
  (:require [clojure.java.io :as io]))


(defn create-folder [fname]
  (io/make-parents fname)
  )
(defn write-file [fname data]
  (spit fname data)
 )

