# example project

This is a mostly-empty project placed here to be a sandbox for any one-off
source listings, exercises, or tests you might like to write. It's preconfigured
with JUnit, Mockito, and Hamcrest.

See `../example-cucumber` for an example project that's pre-configured to run
Cucumber tests.

## example code

In the code that's included in this project, you'll see an example of a
collaborator test (for `FeedsWalrus`), and two regression tests (for `OpensCan`
and `Walrus`). They serve as examples of using JUnit, Hamcrest, and Mockito.

```
.
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── example
│   │           ├── FeedsWalrus.java
│   │           ├── OpensCan.java
│   │           └── values
│   │               ├── CannedWalrusFood.java
│   │               ├── Walrus.java
│   │               └── WalrusFood.java
│   └── test
│       └── java
│           └── example
│               ├── FeedsWalrusTest.java
│               ├── OpensCanTest.java
│               └── values
│                   └── WalrusTest.java
```
