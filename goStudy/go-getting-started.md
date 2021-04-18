# Tutorial: Get started with Go

| [Prerequisites](https://golang.google.cn/doc/tutorial/getting-started#prerequisites)[Install Go](https://golang.google.cn/doc/tutorial/getting-started#install)[Write some code](https://golang.google.cn/doc/tutorial/getting-started#code)[Call code in an external package](https://golang.google.cn/doc/tutorial/getting-started#call)[Write more code](https://golang.google.cn/doc/tutorial/getting-started#write-more) |      |
| ---------------------------------------- | ---- |
|                                          |      |

In this tutorial, you'll get a brief introduction to Go programming. Along the way, you will:

- Install Go (if you haven't already).
- Write some simple "Hello, world" code.
- Use the `go` command to run your code.
- Use the Go package discovery tool to find packages you can use in your own code.
- Call functions of an external module.

**Note:** For other tutorials, see [Tutorials](https://golang.google.cn/doc/tutorial/index.html).

## Prerequisites

- **Some programming experience.** The code here is pretty simple, but it helps to know something about functions.
- **A tool to edit your code.** Any text editor you have will work fine. Most text editors have good support for Go. The most popular are VSCode (free), GoLand (paid), and Vim (free).
- **A command terminal.** Go works well using any terminal on Linux and Mac, and on PowerShell or cmd in Windows.

## Install Go

Just use the [Download and install](https://golang.google.cn/doc/install) steps.

## Write some code

Get started with Hello, World.

1. Open a command prompt and cd to your home directory.

   On Linux or Mac:

   ```
   cd

   ```

   On Windows:

   ```
   cd %HOMEPATH%

   ```

2. Create a hello directory for your first Go source code.

   For example, use the following commands:

   ```
   mkdir hello
   cd hello

   ```

3. Enable dependency tracking for your code.

   When your code imports packages contained in other modules, you manage those dependencies through your code's own module. That module is defined by a go.mod file that tracks the modules that provide those packages. That go.mod file stays with your code, including in your source code repository.

   To enable dependency tracking for your code by creating a go.mod file, run the [`go mod init` command](https://golang.google.cn/ref/mod#go-mod-init), giving it the name of the module your code will be in. The name is the module's module path. In most cases, this will be the repository location where your source code will be kept, such as `github.com/mymodule`. If you plan to publish your module for others to use, the module path *must* be a location from which Go tools can download your module.

   For the purposes of this tutorial, just use `example.com/hello`.

   ```
   $ go mod init example.com/hello
   go: creating new go.mod: module example.com/hello

   ```

4. In your text editor, create a file hello.go in which to write your code.

5. Paste the following code into your hello.go file and save the file.

   ```
   package main

   import "fmt"

   func main() {
       fmt.Println("Hello, World!")
   }

   ```

   This is your Go code. In this code, you:

   - Declare a `main` package (a package is a way to group functions, and it's made up of all the files in the same directory).
   - Import the popular [`fmt` package](https://pkg.go.dev/fmt/), which contains functions for formatting text, including printing to the console. This package is one of the [standard library](https://pkg.go.dev/std) packages you got when you installed Go.
   - Implement a `main` function to print a message to the console. A `main` function executes by default when you run the `main` package.

6. Run your code to see the greeting.

   ```
   $ go run .
   Hello, World!

   ```

   The [`go run` command](https://golang.google.cn/cmd/go/#hdr-Compile_and_run_Go_program) is one of many `go` commands you'll use to get things done with Go. Use the following command to get a list of the others:

   ```
   $ go help

   ```

## Call code in an external package

When you need your code to do something that might have been implemented by someone else, you can look for a package that has functions you can use in your code.

1. Make your printed message a little more interesting with a function from an external module.

   1. Visit pkg.go.dev and [search for a "quote" package](https://pkg.go.dev/search?q=quote).
   2. Locate and click the `rsc.io/quote` package in search results (if you see `rsc.io/quote/v3`, ignore it for now).
   3. In the **Documentation** section, under **Index**, note the list of functions you can call from your code. You'll use the `Go` function.
   4. At the top of this page, note that package `quote` is included in the `rsc.io/quote` module.

   You can use the pkg.go.dev site to find published modules whose packages have functions you can use in your own code. Packages are published in modules -- like `rsc.io/quote` -- where others can use them. Modules are improved with new versions over time, and you can upgrade your code to use the improved versions.

2. In your Go code, import the

    

   ```
   rsc.io/quote
   ```

    

   package and add a call to its

    

   ```
   Go
   ```

    

   function.

   After adding the highlighted lines, your code should include the following:

   ```
   package main

   import "fmt"

   import "rsc.io/quote"

   func main() {
       fmt.Println(quote.Go())
   }

   ```

3. Add new module requirements and sums.

   Go will add the `quote` module as a requirement, as well as a go.sum file for use in authenticating the module. For more, see [Authenticating modules](https://golang.google.cn/ref/mod#authenticating) in the Go Modules Reference.

   ```
   $ go mod tidy
   go: finding module for package rsc.io/quote
   go: found rsc.io/quote in rsc.io/quote v1.5.2

   ```

4. Run your code to see the message generated by the function you're calling.

   ```
   $ go run .
   Don't communicate by sharing memory, share memory by communicating.

   ```

   Notice that your code calls the `Go` function, printing a clever message about communication.

   When you ran `go mod tidy`, it located and downloaded the `rsc.io/quote` module that contains the package you imported. By default, it downloaded the latest version -- v1.5.2.

## Write more code

With this quick introduction, you got Go installed and learned some of the basics. To write some more code with another tutorial, take a look at [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).



# Tutorial: Create a Go module

| [Prerequisites](https://golang.google.cn/doc/tutorial/create-module#prerequisites)[Start a module that others can use](https://golang.google.cn/doc/tutorial/create-module#start) |      |
| ---------------------------------------- | ---- |
|                                          |      |

This is the first part of a tutorial that introduces a few fundamental features of the Go language. If you're just getting started with Go, be sure to take a look at [Tutorial: Get started with Go](https://golang.google.cn/doc/tutorial/getting-started.html), which introduces the `go` command, Go modules, and very simple Go code.

In this tutorial you'll create two modules. The first is a library which is intended to be imported by other libraries or applications. The second is a caller application which will use the first.

This tutorial's sequence includes seven brief topics that each illustrate a different part of the language.

1. Create a module -- Write a small module with functions you can call from another module.
2. [Call your code from another module](https://golang.google.cn/doc/tutorial/call-module-code.html) -- Import and use your new module.
3. [Return and handle an error](https://golang.google.cn/doc/tutorial/handle-errors.html) -- Add simple error handling.
4. [Return a random greeting](https://golang.google.cn/doc/tutorial/random-greeting.html) -- Handle data in slices (Go's dynamically-sized arrays).
5. [Return greetings for multiple people](https://golang.google.cn/doc/tutorial/greetings-multiple-people.html) -- Store key/value pairs in a map.
6. [Add a test](https://golang.google.cn/doc/tutorial/add-a-test.html) -- Use Go's built-in unit testing features to test your code.
7. [Compile and install the application](https://golang.google.cn/doc/tutorial/compile-install.html) -- Compile and install your code locally.

**Note:** For other tutorials, see [Tutorials](https://golang.google.cn/doc/tutorial/index.html).

## Prerequisites

- **Some programming experience.** The code here is pretty simple, but it helps to know something about functions, loops, and arrays.
- **A tool to edit your code.** Any text editor you have will work fine. Most text editors have good support for Go. The most popular are VSCode (free), GoLand (paid), and Vim (free).
- **A command terminal.** Go works well using any terminal on Linux and Mac, and on PowerShell or cmd in Windows.

## Start a module that others can use

Start by creating a Go module. In a module, you collect one or more related packages for a discrete and useful set of functions. For example, you might create a module with packages that have functions for doing financial analysis so that others writing financial applications can use your work. For more about developing modules, see [Developing and publishing modules](https://golang.google.cn/doc/modules/developing).

Go code is grouped into packages, and packages are grouped into modules. Your module specifies dependencies needed to run your code, including the Go version and the set of other modules it requires.

As you add or improve functionality in your module, you publish new versions of the module. Developers writing code that calls functions in your module can import the module's updated packages and test with the new version before putting it into production use.

1. Open a command prompt and

    

   ```
   cd
   ```

    

   to your home directory.

   On Linux or Mac:

   ```
   cd

   ```

   On Windows:

   ```
   cd %HOMEPATH%

   ```

2. Create a

    

   ```
   greetings
   ```

    

   directory for your Go module source code.

   For example, from your home directory use the following commands:

   ```
   mkdir greetings
   cd greetings

   ```

3. Start your module using the

    

   `go mod init` command

   .

   Run the `go mod init` command, giving it your module path -- here, use `example.com/greetings`. If you publish a module, this *must* be a path from which your module can be downloaded by Go tools. That would be your code's repository.

   ```
   $ go mod init example.com/greetings
   go: creating new go.mod: module example.com/greetings

   ```

   The `go mod init` command creates a go.mod file to track your code's dependencies. So far, the file includes only the name of your module and the Go version your code supports. But as you add dependencies, the go.mod file will list the versions your code depends on. This keeps builds reproducible and gives you direct control over which module versions to use.

4. In your text editor, create a file in which to write your code and call it greetings.go.

5. Paste the following code into your greetings.go file and save the file.

   ```
   package greetings

   import "fmt"

   // Hello returns a greeting for the named person.
   func Hello(name string) string {
       // Return a greeting that embeds the name in a message.
       message := fmt.Sprintf("Hi, %v. Welcome!", name)
       return message
   }

   ```

   This is the first code for your module. It returns a greeting to any caller that asks for one. You'll write code that calls this function in the next step.

   In this code, you:

   - Declare a `greetings` package to collect related functions.

   - Implement a

      

     ```
     Hello
     ```

      

     function to return the greeting.

     This function takes a `name` parameter whose type is `string`. The function also returns a `string`. In Go, a function whose name starts with a capital letter can be called by a function not in the same package. This is known in Go as an exported name. For more about exported names, see [Exported names](https://tour.golang.org/basics/3) in the Go tour.

     ​

   - Declare a

      

     ```
     message
     ```

      

     variable to hold your greeting.

     In Go, the `:=` operator is a shortcut for declaring and initializing a variable in one line (Go uses the value on the right to determine the variable's type). Taking the long way, you might have written this as:

     ```
     var message string
     message = fmt.Sprintf("Hi, %v. Welcome!", name)

     ```

   - Use the `fmt` package's [`Sprintf` function](https://pkg.go.dev/fmt/#Sprintf) to create a greeting message. The first argument is a format string, and `Sprintf` substitutes the `name` parameter's value for the `%v` format verb. Inserting the value of the `name` parameter completes the greeting text.

   - Return the formatted greeting text to the caller.

In the next step, you'll call this function from another module.

# Call your code from another module

In the [previous section](https://golang.google.cn/doc/tutorial/create-module.html), you created a `greetings` module. In this section, you'll write code to make calls to the `Hello` function in the module you just wrote. You'll write code you can execute as an application, and which calls code in the `greetings` module.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

1. Create a

    

   ```
   hello
   ```

    

   directory for your Go module source code. This is where you'll write your caller.

   After you create this directory, you should have both a hello and a greetings directory at the same level in the hierarchy, like so:

   ```
   <home>/
    |-- greetings/
    |-- hello/
   ```

   For example, if your command prompt is in the greetings directory, you could use the following commands:

   ```
   cd ..
   mkdir hello
   cd hello

   ```

2. Enable dependency tracking for the code you're about to write.

   To enable dependency tracking for your code, run the [`go mod init` command](https://golang.google.cn/ref/mod#go-mod-init), giving it the name of the module your code will be in.

   For the purposes of this tutorial, use `example.com/hello` for the module path.

   ```
   $ go mod init example.com/hello
   go: creating new go.mod: module example.com/hello

   ```

3. In your text editor, in the hello directory, create a file in which to write your code and call it hello.go.

4. Write code to call the

    

   ```
   Hello
   ```

    

   function, then print the function's return value.

   To do that, paste the following code into hello.go.

   ```
   package main

   import (
       "fmt"

       "example.com/greetings"
   )

   func main() {
       // Get a greeting message and print it.
       message := greetings.Hello("Gladys")
       fmt.Println(message)
   }

   ```

   In this code, you:

   - Declare a `main` package. In Go, code executed as an application must be in a `main` package.
   - Import two packages: `example.com/greetings` and the [`fmt` package](https://pkg.go.dev/fmt/). This gives your code access to functions in those packages. Importing `example.com/greetings` (the package contained in the module you created earlier) gives you access to the `Hello` function. You also import `fmt`, with functions for handling input and output text (such as printing text to the console).
   - Get a greeting by calling the `greetings` package’s `Hello` function.

5. Edit the

    

   ```
   example.com/hello
   ```

    

   module to use your local

    

   ```
   example.com/greetings
   ```

    

   module.

   For production use, you’d publish the `example.com/greetings` module from its repository (with a module path that reflected its published location), where Go tools could find it to download it. For now, because you haven't published the module yet, you need to adapt the `example.com/hello` module so it can find the `example.com/greetings` code on your local file system.

   To do that, use the [`go mod edit` command](https://golang.google.cn/ref/mod#go-mod-edit) to edit the `example.com/hello` module to redirect Go tools from its module path (where the module isn't) to the local directory (where it is).

   1. From the command prompt in the hello directory, run the following command:

      ```
      $ go mod edit -replace=example.com/greetings=../greetings

      ```

      The command specifies that `example.com/greetings` should be replaced with `../greetings` for the purpose of locating the dependency. After you run the command, the go.mod file in the hello directory should include a [`replace` directive](https://golang.google.cn/doc/modules/gomod-ref#replace):

      ```
      module example.com/hello

      go 1.16

      replace example.com/greetings => ../greetings

      ```

   2. From the command prompt in the hello directory, run the

       

      `go mod tidy` command

       

      to synchronize the

       

      ```
      example.com/hello
      ```

       

      module's dependencies, adding those required by the code, but not yet tracked in the module.

      ```
      $ go mod tidy
      go: found example.com/greetings in example.com/greetings v0.0.0-00010101000000-000000000000

      ```

      After the command completes, the `example.com/hello` module's go.mod file should look like this:

      ```
      module example.com/hello

      go 1.16

      replace example.com/greetings => ../greetings

      require example.com/greetings v0.0.0-00010101000000-000000000000
      ```

      The command found the local code in the greetings directory, then added a [`require` directive](https://golang.google.cn/doc/modules/gomod-ref#require) to specify that `example.com/hello` requires `example.com/greetings`. You created this dependency when you imported the `greetings` package in hello.go.

      The number following the module path is a *pseudo-version number* -- a generated number used in place of a semantic version number (which the module doesn't have yet).

      To reference a *published* module, a go.mod file would typically omit the `replace` directive and use a `require` directive with a tagged version number at the end.

      ```
      require example.com/greetings v1.1.0
      ```

      For more on version numbers, see [Module version numbering](https://golang.google.cn/doc/modules/version-numbers).

6. At the command prompt in the

    

   ```
   hello
   ```

    

   directory, run your code to confirm that it works.

   ```
   $ go run .
   Hi, Gladys. Welcome!

   ```

Congrats! You've written two functioning modules.

In the next topic, you'll add some error handling.

# Return and handle an error

Handling errors is an essential feature of solid code. In this section, you'll add a bit of code to return an error from the greetings module, then handle it in the caller.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

1. In greetings/greetings.go, add the code highlighted below.

   There's no sense sending a greeting back if you don't know who to greet. Return an error to the caller if the name is empty. Copy the following code into greetings.go and save the file.

   ```
   package greetings

   import (
       "errors"
       "fmt"
   )

   // Hello returns a greeting for the named person.
   func Hello(name string) (string, error) {
       // If no name was given, return an error with a message.
       if name == "" {
           return "", errors.New("empty name")
       }

       // If a name was received, return a value that embeds the name
       // in a greeting message.
       message := fmt.Sprintf("Hi, %v. Welcome!", name)
       return message, nil
   }

   ```

   In this code, you:

   - Change the function so that it returns two values: a `string` and an `error`. Your caller will check the second value to see if an error occurred. (Any Go function can return multiple values. For more, see [Effective Go](https://golang.google.cn/doc/effective_go.html#multiple-returns).)
   - Import the Go standard library `errors` package so you can use its [`errors.New` function](https://pkg.go.dev/errors/#example-New).
   - Add an `if` statement to check for an invalid request (an empty string where the name should be) and return an error if the request is invalid. The `errors.New` function returns an `error` with your message inside.
   - Add `nil` (meaning no error) as a second value in the successful return. That way, the caller can see that the function succeeded.

2. In your hello/hello.go file, handle the error now returned by the

    

   ```
   Hello
   ```

    

   function, along with the non-error value.

   Paste the following code into hello.go.

   ```
   package main

   import (
       "fmt"
       "log"

       "example.com/greetings"
   )

   func main() {
       // Set properties of the predefined Logger, including
       // the log entry prefix and a flag to disable printing
       // the time, source file, and line number.
       log.SetPrefix("greetings: ")
       log.SetFlags(0)

       // Request a greeting message.
       message, err := greetings.Hello("")
       // If an error was returned, print it to the console and
       // exit the program.
       if err != nil {
           log.Fatal(err)
       }

       // If no error was returned, print the returned message
       // to the console.
       fmt.Println(message)
   }

   ```

   In this code, you:

   - Configure the [`log` package](https://pkg.go.dev/log/) to print the command name ("greetings: ") at the start of its log messages, without a time stamp or source file information.
   - Assign both of the `Hello` return values, including the `error`, to variables.
   - Change the `Hello` argument from Gladys’s name to an empty string, so you can try out your error-handling code.
   - Look for a non-nil `error` value. There's no sense continuing in this case.
   - Use the functions in the standard library's `log package` to output error information. If you get an error, you use the `log` package's [`Fatal` function](https://pkg.go.dev/log?tab=doc#Fatal) to print the error and stop the program.

3. At the command line in the

    

   ```
   hello
   ```

    

   directory, run hello.go to confirm that the code works.

   Now that you're passing in an empty name, you'll get an error.

   ```
   $ go run .
   greetings: empty name
   exit status 1

   ```

That's common error handling in Go: Return an error as a value so the caller can check for it.

Next, you'll use a Go slice to return a randomly-selected greeting.

# Return a random greeting

In this section, you'll change your code so that instead of returning a single greeting every time, it returns one of several predefined greeting messages.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

To do this, you'll use a Go slice. A slice is like an array, except that its size changes dynamically as you add and remove items. The slice is one of Go's most useful types.

You'll add a small slice to contain three greeting messages, then have your code return one of the messages randomly. For more on slices, see [Go slices](https://blog.golang.org/slices-intro) in the Go blog.

1. In greetings/greetings.go, change your code so it looks like the following.

   ```
   package greetings

   import (
       "errors"
       "fmt"
       "math/rand"
       "time"
   )

   // Hello returns a greeting for the named person.
   func Hello(name string) (string, error) {
       // If no name was given, return an error with a message.
       if name == "" {
           return name, errors.New("empty name")
       }
       // Create a message using a random format.
       message := fmt.Sprintf(randomFormat(), name)
       return message, nil
   }

   // init sets initial values for variables used in the function.
   func init() {
       rand.Seed(time.Now().UnixNano())
   }

   // randomFormat returns one of a set of greeting messages. The returned
   // message is selected at random.
   func randomFormat() string {
       // A slice of message formats.
       formats := []string{
           "Hi, %v. Welcome!",
           "Great to see you, %v!",
           "Hail, %v! Well met!",
       }

       // Return a randomly selected message format by specifying
       // a random index for the slice of formats.
       return formats[rand.Intn(len(formats))]
   }

   ```

   In this code, you:

   - Add a `randomFormat` function that returns a randomly selected format for a greeting message. Note that `randomFormat` starts with a lowercase letter, making it accessible only to code in its own package (in other words, it's not exported).
   - In `randomFormat`, declare a `formats` slice with three message formats. When declaring a slice, you omit its size in the brackets, like this: `[]string`. This tells Go that the size of the array underlying the slice can be dynamically changed.
   - Use the [`math/rand` package](https://pkg.go.dev/math/rand/) to generate a random number for selecting an item from the slice.
   - Add an `init` function to seed the `rand` package with the current time. Go executes `init` functions automatically at program startup, after global variables have been initialized. For more about `init` functions, see [Effective Go](https://golang.google.cn/doc/effective_go.html#init).
   - In `Hello`, call the `randomFormat` function to get a format for the message you'll return, then use the format and `name` value together to create the message.
   - Return the message (or an error) as you did before.

2. In hello/hello.go, change your code so it looks like the following.

   You're just adding Gladys's name (or a different name, if you like) as an argument to the `Hello` function call in hello.go.

   ```
   package main

   import (
       "fmt"
       "log"

       "example.com/greetings"
   )

   func main() {
       // Set properties of the predefined Logger, including
       // the log entry prefix and a flag to disable printing
       // the time, source file, and line number.
       log.SetPrefix("greetings: ")
       log.SetFlags(0)

       // Request a greeting message.
       message, err := greetings.Hello("Gladys")
       // If an error was returned, print it to the console and
       // exit the program.
       if err != nil {
           log.Fatal(err)
       }

       // If no error was returned, print the returned message
       // to the console.
       fmt.Println(message)
   }
   ```

3. At the command line, in the hello directory, run hello.go to confirm that the code works. Run it multiple times, noticing that the greeting changes.

   ```
   $ go run .
   Great to see you, Gladys!

   $ go run .
   Hi, Gladys. Welcome!

   $ go run .
   Hail, Gladys! Well met!

   ```

Next, you'll use a slice to greet multiple people.

# Return greetings for multiple people

In the last changes you'll make to your module's code, you'll add support for getting greetings for multiple people in one request. In other words, you'll handle a multiple-value input, then pair values in that input with a multiple-value output. To do this, you'll need to pass a set of names to a function that can return a greeting for each of them.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

But there's a hitch. Changing the `Hello` function's parameter from a single name to a set of names would change the function's signature. If you had already published the `example.com/greetings` module and users had already written code calling `Hello`, that change would break their programs.

In this situation, a better choice is to write a new function with a different name. The new function will take multiple parameters. That preserves the old function for backward compatibility.

1. In greetings/greetings.go, change your code so it looks like the following.

   ```
   package greetings

   import (
       "errors"
       "fmt"
       "math/rand"
       "time"
   )

   // Hello returns a greeting for the named person.
   func Hello(name string) (string, error) {
       // If no name was given, return an error with a message.
       if name == "" {
           return name, errors.New("empty name")
       }
       // Create a message using a random format.
       message := fmt.Sprintf(randomFormat(), name)
       return message, nil
   }

   // Hellos returns a map that associates each of the named people
   // with a greeting message.
   func Hellos(names []string) (map[string]string, error) {
       // A map to associate names with messages.
       messages := make(map[string]string)
       // Loop through the received slice of names, calling
       // the Hello function to get a message for each name.
       for _, name := range names {
           message, err := Hello(name)
           if err != nil {
               return nil, err
           }
           // In the map, associate the retrieved message with
           // the name.
           messages[name] = message
       }
       return messages, nil
   }

   // Init sets initial values for variables used in the function.
   func init() {
       rand.Seed(time.Now().UnixNano())
   }

   // randomFormat returns one of a set of greeting messages. The returned
   // message is selected at random.
   func randomFormat() string {
       // A slice of message formats.
       formats := []string{
           "Hi, %v. Welcome!",
           "Great to see you, %v!",
           "Hail, %v! Well met!",
       }

       // Return one of the message formats selected at random.
       return formats[rand.Intn(len(formats))]
   }

   ```

   In this code, you:

   - Add a `Hellos` function whose parameter is a slice of names rather than a single name. Also, you change one of its return types from a `string` to a `map` so you can return names mapped to greeting messages.
   - Have the new `Hellos` function call the existing `Hello` function. This helps reduce duplication while also leaving both functions in place.
   - Create a `messages` map to associate each of the received names (as a key) with a generated message (as a value). In Go, you initialize a map with the following syntax: `make(map[*key-type*]*value-type*)`. You have the `Hellos` function return this map to the caller. For more about maps, see [Go maps in action](https://blog.golang.org/maps) on the Go blog.
   - Loop through the names your function received, checking that each has a non-empty value, then associate a message with each. In this `for` loop, `range` returns two values: the index of the current item in the loop and a copy of the item's value. You don't need the index, so you use the Go blank identifier (an underscore) to ignore it. For more, see [The blank identifier](https://golang.google.cn/doc/effective_go.html#blank) in Effective Go.

2. In your hello/hello.go calling code, pass a slice of names, then print the contents of the names/messages map you get back.

   In hello.go, change your code so it looks like the following.

   ```
   package main

   import (
       "fmt"
       "log"

       "example.com/greetings"
   )

   func main() {
       // Set properties of the predefined Logger, including
       // the log entry prefix and a flag to disable printing
       // the time, source file, and line number.
       log.SetPrefix("greetings: ")
       log.SetFlags(0)

       // A slice of names.
       names := []string{"Gladys", "Samantha", "Darrin"}

       // Request greeting messages for the names.
       messages, err := greetings.Hellos(names)
       if err != nil {
           log.Fatal(err)
       }
       // If no error was returned, print the returned map of
       // messages to the console.
       fmt.Println(messages)
   }

   ```

   With these changes, you:

   - Create a `names` variable as a slice type holding three names.
   - Pass the `names` variable as the argument to the `Hellos` function.

3. At the command line, change to the directory that contains hello/hello.go, then use

    

   ```
   go run
   ```

    

   to confirm that the code works.

   The output should be a string representation of the map associating names with messages, something like the following:

   ```
   $ go run .
   map[Darrin:Hail, Darrin! Well met! Gladys:Hi, Gladys. Welcome! Samantha:Hail, Samantha! Well met!]

   ```

This topic introduced maps for representing name/value pairs. It also introduced the idea of preserving backward compatibility by implementing a new function for new or changed functionality in a module. For more about backward compatibility, see [Keeping your modules compatible](https://blog.golang.org/module-compatibility).

Next, you'll use built-in Go features to create a unit test for your code.

# Add a test

Now that you've gotten your code to a stable place (nicely done, by the way), add a test. Testing your code during development can expose bugs that find their way in as you make changes. In this topic, you add a test for the `Hello` function.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

Go's built-in support for unit testing makes it easier to test as you go. Specifically, using naming conventions, Go's `testing` package, and the `go test` command, you can quickly write and execute tests.

1. In the greetings directory, create a file called greetings_test.go.

   Ending a file's name with _test.go tells the `go test` command that this file contains test functions.

2. In greetings_test.go, paste the following code and save the file.

   ```
   package greetings

   import (
       "testing"
       "regexp"
   )

   // TestHelloName calls greetings.Hello with a name, checking
   // for a valid return value.
   func TestHelloName(t *testing.T) {
       name := "Gladys"
       want := regexp.MustCompile(`\b`+name+`\b`)
       msg, err := Hello("Gladys")
       if !want.MatchString(msg) || err != nil {
           t.Fatalf(`Hello("Gladys") = %q, %v, want match for %#q, nil`, msg, err, want)
       }
   }

   // TestHelloEmpty calls greetings.Hello with an empty string,
   // checking for an error.
   func TestHelloEmpty(t *testing.T) {
       msg, err := Hello("")
       if msg != "" || err == nil {
           t.Fatalf(`Hello("") = %q, %v, want "", error`, msg, err)
       }
   }

   ```

   In this code, you:

   - Implement test functions in the same package as the code you're testing.
   - Create two test functions to test the `greetings.Hello` function. Test function names have the form `Test*Name*`, where *Name* says something about the specific test. Also, test functions take a pointer to the `testing` package's [`testing.T` type](https://pkg.go.dev/testing/#T) as a parameter. You use this parameter's methods for reporting and logging from your test.
   - Implement two tests:
     - `TestHelloName` calls the `Hello` function, passing a `name` value with which the function should be able to return a valid response message. If the call returns an error or an unexpected response message (one that doesn't include the name you passed in), you use the `t` parameter's [`Fatalf` method](https://pkg.go.dev/testing/#T.Fatalf) to print a message to the console and end execution.
     - `TestHelloEmpty` calls the `Hello` function with an empty string. This test is designed to confirm that your error handling works. If the call returns a non-empty string or no error, you use the `t` parameter's `Fatalf` method to print a message to the console and end execution.

3. At the command line in the greetings directory, run the

    

   `go test` command

    

   to execute the test.

   The `go test` command executes test functions (whose names begin with `Test`) in test files (whose names end with _test.go). You can add the `-v` flag to get verbose output that lists all of the tests and their results.

   The tests should pass.

   ```
   $ go test
   PASS
   ok      example.com/greetings   0.364s

   $ go test -v
   === RUN   TestHelloName
   --- PASS: TestHelloName (0.00s)
   === RUN   TestHelloEmpty
   --- PASS: TestHelloEmpty (0.00s)
   PASS
   ok      example.com/greetings   0.372s

   ```

4. Break the

    

   ```
   greetings.Hello
   ```

    

   function to view a failing test.

   The `TestHelloName` test function checks the return value for the name you specified as a `Hello` function parameter. To view a failing test result, change the `greetings.Hello` function so that it no longer includes the name.

   In greetings/greetings.go, paste the following code in place of the `Hello` function. Note that the highlighted lines change the value that the function returns, as if the `name` argument had been accidentally removed.

   ```
   // Hello returns a greeting for the named person.
   func Hello(name string) (string, error) {
       // If no name was given, return an error with a message.
       if name == "" {
           return name, errors.New("empty name")
       }
       // Create a message using a random format.
       // message := fmt.Sprintf(randomFormat(), name)
       message := fmt.Sprint(randomFormat())
       return message, nil
   }

   ```

5. At the command line in the greetings directory, run

    

   ```
   go test
   ```

    

   to execute the test.

   This time, run `go test` without the `-v` flag. The output will include results for only the tests that failed, which can be useful when you have a lot of tests. The `TestHelloName` test should fail -- `TestHelloEmpty` still passes.

   ```
   $ go test
   --- FAIL: TestHelloName (0.00s)
       greetings_test.go:15: Hello("Gladys") = "Hail, %v! Well met!", <nil>, want match for `\bGladys\b`, nil
   FAIL
   exit status 1
   FAIL    example.com/greetings   0.182s

   ```

In the next (and last) topic, you'll see how to compile and install your code to run it locally.

# Compile and install the application

In this last topic, you'll learn a couple new `go` commands. While the `go run` command is a useful shortcut for compiling and running a program when you're making frequent changes, it doesn't generate a binary executable.

This topic introduces two additional commands for building code:

- The [`go build` command](https://golang.google.cn/cmd/go/#hdr-Compile_packages_and_dependencies) compiles the packages, along with their dependencies, but it doesn't install the results.
- The [`go install` command](https://golang.google.cn/ref/mod#go-install) compiles and installs the packages.

**Note:** This topic is part of a multi-part tutorial that begins with [Create a Go module](https://golang.google.cn/doc/tutorial/create-module.html).

1. From the command line in the hello directory, run the

    

   ```
   go build
   ```

    

   command to compile the code into an executable.

   ```
   $ go build
   ```

2. From the command line in the hello directory, run the new

    

   ```
   hello
   ```

    

   executable to confirm that the code works.

   Note that your result might differ depending on whether you changed your greetings.go code after testing it.

   - On Linux or Mac:

     ```
     $ ./hello
     map[Darrin:Great to see you, Darrin! Gladys:Hail, Gladys! Well met! Samantha:Hail, Samantha! Well met!]

     ```

   - On Windows:

     ```
     $ hello.exe
     map[Darrin:Great to see you, Darrin! Gladys:Hail, Gladys! Well met! Samantha:Hail, Samantha! Well met!]

     ```

   You've compiled the application into an executable so you can run it. But to run it currently, your prompt needs either to be in the executable's directory, or to specify the executable's path.

   Next, you'll install the executable so you can run it without specifying its path.

3. Discover the Go install path, where the

    

   ```
   go
   ```

    

   command will install the current package.

   You can discover the install path by running the [`go list` command](https://golang.google.cn/cmd/go/#hdr-List_packages_or_modules), as in the following example:

   ```
   $ go list -f '{{.Target}}'

   ```

   For example, the command's output might say `/home/gopher/bin/hello`, meaning that binaries are installed to /home/gopher/bin. You'll need this install directory in the next step.

4. Add the Go install directory to your system's shell path.

   That way, you'll be able to run your program's executable without specifying where the executable is.

   - On Linux or Mac, run the following command:

     ```
     $ export PATH=$PATH:/path/to/your/install/directory

     ```

   - On Windows, run the following command:

     ```
     $ set PATH=%PATH%;C:\path\to\your\install\directory

     ```

   As an alternative, if you already have a directory like `$HOME/bin` in your shell path and you'd like to install your Go programs there, you can change the install target by setting the `GOBIN` variable using the [`go env` command](https://golang.google.cn/cmd/go/#hdr-Print_Go_environment_information):

   ```
   $ go env -w GOBIN=/path/to/your/bin

   ```

   or

   ```
   $ go env -w GOBIN=C:\path\to\your\bin

   ```

5. Once you've updated the shell path, run the

    

   ```
   go install
   ```

    

   command to compile and install the package.

   ```
   $ go install
   ```

6. Run your application by simply typing its name. To make this interesting, open a new command prompt and run the

    

   ```
   hello
   ```

    

   executable name in some other directory.

   ```
   $ hello
   map[Darrin:Hail, Darrin! Well met! Gladys:Great to see you, Gladys! Samantha:Hail, Samantha! Well met!]

   ```

That wraps up this Go tutorial!

