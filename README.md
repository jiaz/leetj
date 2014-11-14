LeetJ
=====

LeetCode OJ in Java with a simple testing framework and cases. Currently it contains 132 problems with real cases.

Inspired by [LeetSharp](https://github.com/txchen/LeetSharp).

How to use
----------

The `skeleton` branch contains only the test framework and the unimplemented methods.

The `master` branch contains solutions, most of them are optimal but you can always find better solutions than mine.

`Gradle` is used for build and testing and Java 8 is required as the test framework uses some Java 8 features such as Stream and Lambda expression. Only Jdk8 is required to be installed, Gradle will be installed automatically when you first execute the Gradle wrapper `gradlew`.

Run all cases:

```
./gradlew test
```

Run all cases in parallel (with no std output):

```
./gradlew test -DParallel=true
```

Run a single case (where XXX is the case id, e.g. 012):

```
./gradlew qtXXX
```

In case you want to add new problems to it. There are templates for the src class and test class. You can run:

```
./gradlew qcQXXX_ProbemName
```

to generate classes from templates. Replace `XXX` with the problem number and the `ProblemName` with the name.
