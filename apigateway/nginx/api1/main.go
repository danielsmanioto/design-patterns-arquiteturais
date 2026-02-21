package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/api1", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintln(w, "Hello from API 1")
	})
	log.Fatal(http.ListenAndServe(":8080", nil))
}
