(ns wake.generator.io-test
  (:require
    [clojure.test :refer :all]
    [wake.generator.io :as io]))

(deftest edn-read-write-test
  (testing "round trip test"
    (is (= "{:base-path \"/\", :env #ig/ref :system/env}\n"
           (io/edn->str (io/str->edn "{:base-path \"/\" :env #ig/ref :system/env}"))))

    (is (= "{:port #long #or [#env PORT 3000], :handler #ig/ref :handler/ring}\n"
           (io/edn->str (io/str->edn "{:port    #long #or [#env PORT 3000]\n  :handler #ig/ref :handler/ring}"))))

    (is (= "{'foo :bar}\n"
           (io/edn->str (io/str->edn "{'foo :bar}"))))))