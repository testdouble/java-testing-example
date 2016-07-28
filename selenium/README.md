# selenium

This project includes several Selenium examples in both JUnit and Cucumber. We
will also use it to practice a Tic Tac Toe exercise.

## Prerequisites

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system. By default, this repo is configured to launch Firefox.
If you don't have Firefox available, you can also use Chrome or Internet Explorer.

To change the browser Selenium will launch, edit our
`src/test/resources/selenium.properties` to any of "msie", "chrome", or "firefox".

To run Chrome, you'll need `chromedriver` on your path. A Windows executable has
been included in this project's `bin/` directory.

To run Internet Explorer, you'll need to also be running `bin/IEDriverServer.exe`,
so that Selenium can communicate with the browser.

## Examples

Here's a look at what the project contains:

```
.
├── bin
│   ├── IEDriverServer.exe
│   └── chromedriver.exe
├── src
│   ├── main
│   │   └── java
│   └── test
│       ├── java
│       │   ├── support
│       │   │   └── Browser.java
│       │   ├── example
│       │   │   └── GoogleTest.java
│       │   └── todo
│       │       ├── TodoCukeTest.java
│       │       ├── TodoSteps.java
│       │       ├── TodoTest.java
│       │       └── TodoUtil.java
│       └── resources
│           ├── selenium.properties
│           └── todo
│               └── todos.feature
```

We'll break it down below.

### support.Browser

`Browser` is a helper class created to ease some of the pain of configuring
Selenium to launch a browser and search for elements both expected to and not
expected to exist on the page. It will read from
`src/test/resources/selenium.properties` to determine which browser to launch.

To see how the class is used, look at the two included examples:

### example.GoogleTest

`example.GoogleTest` is a minimal JUnit test that uses Selenium to search Google
and verify—when searching for "Cheese!"—that "cheese curds" is one of the
auto-complete suggestions.

### todo.*

The `todo` package contains lots of tests of [this todo
app](http://testdouble.github.io/todos/), both in JUnit and in Cucumber. It
defines a `TodoUtil` helper class to make the tests a little easier to read,
removing some of the "selenese" from the story the tests are trying to tell.

### tictactoe.*

The primary exercise in this project is to attempt to write some tests against
a simple interface with non-deterministic behavior against this
[tic-tac-toe](http://tic-tac-toe-kb.herokuapp.com) game:

http://tic-tac-toe-kb.herokuapp.com

The interface is complex enough to warrant some helpers (perhaps organized as
[Page Objects](http://martinfowler.com/bliki/PageObject.html), but any tests will
need to be designed cleverly, in such a way as to react to the move of the site's
AI opponent. In effect, your test will need to be enough of an AI in its own
right to be confident that the tic-tac-toe app is up-and-running.

You may use either JUnit or Cucumber to drive the `tictactoe.TicTacToeTest`. If
you're stuck, we recommend looking at the tests in the `todo` package for
reference.
