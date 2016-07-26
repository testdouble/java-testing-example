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

Or download a ZIP of master [manually](https://github.com/testdouble/java-junit-example/archive/master.zip) and expand the contents someplace on your system

# Prerequisites

* Have a JDK installed
* Have Maven installed and available on your PATH or IDE

# Verify installation

You can verify the project builds correctly from your IDE or from the command 
line.

## CLI

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
$ cd java-junit-example
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

## Eclipse

First, right-click the Project Explorer and select Import -> Import:

<img width="594" alt="screen shot 2016-07-26 at 8 54 50 am" src="https://cloud.githubusercontent.com/assets/79303/17138610/1836e554-530f-11e6-9bc0-e3d830b6216a.png">

Next, choose Maven -> Existing Maven Projects:

<img width="539" alt="screen shot 2016-07-26 at 8 55 08 am" src="https://cloud.githubusercontent.com/assets/79303/17138636/38b1c7e0-530f-11e6-8b76-43d3561bd905.png">

Tell Eclipse where you've downloaded or checked out the project and click Finish:

<img width="649" alt="screen shot 2016-07-26 at 8 55 46 am" src="https://cloud.githubusercontent.com/assets/79303/17138678/697dfa56-530f-11e6-9bd8-18cfcc32cbd5.png">

You should see a progress bar as the project is imported:

<img width="518" alt="screen shot 2016-07-26 at 8 56 02 am" src="https://cloud.githubusercontent.com/assets/79303/17138701/82969a66-530f-11e6-9a9b-ddee2ae4dadd.png">

Once the project is imported, right-click the project, then choose Run As -> 
Maven install:

<img width="801" alt="screen shot 2016-07-26 at 8 57 43 am" src="https://cloud.githubusercontent.com/assets/79303/17138713/90b13034-530f-11e6-88e3-09d286520cd4.png">

If everything has succeeded, you should see a successful build in Eclipse's 
console:

<img width="773" alt="screen shot 2016-07-26 at 8 58 07 am" src="https://cloud.githubusercontent.com/assets/79303/17138742/b1306dd4-530f-11e6-94c4-d9d22305c9f1.png">


# Add Eclipse Plugins

# Change Eclipse Settings

Verify [these settings changes](https://github.com/testdouble/contributing-tests/wiki/JUnit#settings) to Eclipse
