Just a sample project.

# Instructions

Clone the repo:

Git:
```
$ git clone git@github.com:searls/junit-mocha-example.git
```

Svn:
```
$ svn co https://github.com/searls/junit-mocha-example
```

Or download a ZIP of master [manually](https://github.com/searls/junit-mocha-example/archive/master.zip) and expand the contents someplace on your system

# Prerequisites

* Hava a JDK & Maven installed
* Install the latest version of [Node.js](https://nodejs.org/download) from their installer package
* Download [PhantomJS](http://phantomjs.org/download.html) and add it to a directory that's on on your [PATH](https://java.com/en/download/help/path.xml)

# Verify installation

Open a command prompt and verify that all needed bins are on your path and up to date:

```
$ node -v
# ^ if latest, should be at least 0.12.7
$ npm -v
# ^ should be at least 2.0.0
$ phantomjs -v
# ^ should be at least 1.9.8
```

Next, install `testem`, which we will use to run our JavaScript tests:

```
npm install -g testem
```

And verify the install:
```
$ testem --version
# ^ should be at least 0.9.2
```

Finally, verify that `mvn install` succeeds. You should see output like the following:

```
$ cd <Wherever This project Directory is>
$ mvn install
# ...

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.acme.app.HelloWorldProxyTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.357 sec
Running com.acme.app.HelloWorldTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- exec-maven-plugin:1.4.0:exec (default) @ app ---
ok 1 PhantomJS 1.9 - Hello World Proxy returns whatever helloWorld gives it
ok 2 PhantomJS 1.9 - Hello World says hello

1..2
# tests 2
# pass  2
# fail  0

# ok
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ app ---
[INFO] Building jar: junit-mocha-example/target/app-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ app ---
[INFO] Installing junit-mocha-example/target/app-0.0.1-SNAPSHOT.jar to /Users/justin/.m2/repository/com/acme/app/0.0.1-SNAPSHOT/app-0.0.1-SNAPSHOT.jar
[INFO] Installing junit-mocha-example/pom.xml to /Users/justin/.m2/repository/com/acme/app/0.0.1-SNAPSHOT/app-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 9.159 s
[INFO] Finished at: 2015-08-26T13:49:46-04:00
[INFO] Final Memory: 20M/177M
[INFO] ------------------------------------------------------------------------
```

# Add Eclipse Plugins

Install these Eclipse plugins:

* [MoreUnit](http://moreunit.sourceforge.net/#download)
* [EclEmma](http://www.eclemma.org/installation.html)

If either plugin's update site is inaccessible, download the source and manually install the plugin by placing the expanded plugin into the `dropins` folder in your Eclipse installation directory and then restarting Eclipse.

Verify MoreUnit is installed by right-clicking anywhere in a Java source listing and verifying a "MoreUnit" item appears in the context menu.

Verify EclEmma is installed by right-clicking a JUnit test and seeing a "Coverage As…" item in the context menu.

# Change Eclipse Settings

Verify [these settings changes](https://github.com/testdouble/contributing-tests/wiki/JUnit#settings) to Eclipse
