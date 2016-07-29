# java-testing-example

This is the Java repository we'll work out of during this [training
event](https://github.com/testdouble/contributing-tests/wiki/5-Day-Training-Agenda).

## Instructions

Clone the repo:

Git:
```
$ git clone git@github.com:testdouble/java-testing-example.git
```

Svn:
```
$ svn co https://github.com/testdouble/java-testing-example
```

Or download a ZIP of master [manually](https://github.com/testdouble/java-testing-example/archive/master.zip) and expand the contents someplace on your system

## Prerequisites

* Have a JDK installed
* Have Maven installed and available on your PATH or IDE
* Have Firefox installed

## Verify installation

You can verify the project builds correctly from your IDE or from the command
line.

### CLI

Open a command prompt and verify that all needed bins are on your path and up to date:

```
$ java -version
# ^ should be at least 1.6
$ mvn -v
# ^ should be at least 3.0.0
```

Finally, verify that `mvn install` succeeds.

You should see output like the following:

```
$ cd java-testing-example
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

### Eclipse

First, right-click the Project Explorer and select Import -> Import:

<img width="497" alt="screen shot 2016-07-28 at 8 12 09 am" src="https://cloud.githubusercontent.com/assets/79303/17212149/9ef3612a-549b-11e6-882f-981f86677f38.png">

Next, choose Maven -> Existing Maven Projects:

<img width="531" alt="screen shot 2016-07-28 at 8 12 24 am" src="https://cloud.githubusercontent.com/assets/79303/17212171/ae1339c8-549b-11e6-9a72-c8ca0b5bed34.png">

Tell Eclipse where you've downloaded or checked out the project and click Finish:

<img width="655" alt="screen shot 2016-07-28 at 8 12 49 am" src="https://cloud.githubusercontent.com/assets/79303/17212185/b62d09b8-549b-11e6-97fa-f4ae226cfdef.png">

You should see a progress bar as the project is imported:

<img width="518" alt="screen shot 2016-07-26 at 8 56 02 am" src="https://cloud.githubusercontent.com/assets/79303/17138701/82969a66-530f-11e6-9a9b-ddee2ae4dadd.png">

Once the project is imported, right-click the project, then choose Run As ->
Maven install:

<img width="703" alt="screen shot 2016-07-28 at 8 17 57 am" src="https://cloud.githubusercontent.com/assets/79303/17212230/fff899f4-549b-11e6-954d-8159938721af.png">

If everything has succeeded, you should see a successful build in Eclipse's
console:

<img width="905" alt="screen shot 2016-07-28 at 8 19 06 am" src="https://cloud.githubusercontent.com/assets/79303/17212238/05d6ac4e-549c-11e6-9e38-5444885f9e3b.png">

## Continue set up

Once you've verified you have the project working, continue configuring your
environment to start work as described [in this wiki
page](https://github.com/testdouble/contributing-tests/wiki/Environment-Setup#java)
