package main

import (
	"fmt"
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/api2", func(w http.ResponseWriter, r *http.Request) {
		fmt.Fprintln(w, "Hello from API 2")
	})
	log.Fatal(http.ListenAndServe(":8080", nil))
}
