package main

import (
	"fmt"
	"log"
	"testyi.com/greetings"
)

func main() {
	// fmt.Println("hello go")
	// message := greetings.Hello("testyi")
	// fmt.Println(message)
	log.SetPrefix("greetings: ")
	log.SetFlags(0)

	// Request a greeting message.
	// message, err := greetings.Hello("")
	// message, err := greetings.Hello("testyi")
	// A slice of names.
	names := []string{"Testyi", "Gladys", "Samantha"}
	messages, err := greetings.Hellos(names)

	// if an error was returned, print it to the console and exit the program
	if err != nil {
		log.Fatal(err)
	}
	// If no error was returned, print the trturned message to the console
	// fmt.Println(message)
	fmt.Println(messages)
}