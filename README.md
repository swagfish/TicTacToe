# TicTacToe

![alt tag](https://swagfish.github.io/TicTacToe/images/gameplay.gif)

##### Table of Contents  
* [Tests](#tests)
* [Play](#play)
* [Website](#web)
* [Documentation](#doc)
* [Project structure](#structure)
* [Setup](#setup)

<a name="tests" />
## Tests
Master: [![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=master)](https://travis-ci.org/swagfish/TicTacToe)
Develop: [![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=develop)](https://travis-ci.org/swagfish/TicTacToe)

![Heroku](https://heroku-badge.herokuapp.com/?app=arcane-tundra-47758)
[![Code Coverage](https://img.shields.io/codecov/c/github/pvorb/property-providers/develop.svg)](https://codecov.io/github/pvorb/property-providers?branch=develop)

<a name="play" />
## Play
[Swagfish represents TicTacToe](https://arcane-tundra-47758.herokuapp.com/ "TicTacToe")

<a name="web" />
## Project website
[Visit our website](https://swagfish.github.io/TicTacToe/)

<a name="doc" />
## Documentation
[JavaDoc](https://swagfish.github.io/TicTacToe/javadoc/index.html)

<a name="structure" />
## Project structure
```
root
|─ bin
|  |─ check_code.sh
|  |─ clean.sh
|  |─ compile.sh
|  |─ deploy.sh
|  |─ package.sh
|  |─ run_all.sh
|  └─ unit_test.sh
|─ gradle
|─ src
|  |─ main
|  |  |─ java
|  |  |  └─ com
|  |  |     └─ swagfish
|  |  |        |─ server
|  |  |        |  └─ WebServer.java
|  |  |        └─ tictactoe
|  |  |           |─ TicTacToe.java
|  |  |           └─ exceptions
|  |  |              |─ AlreadyOverException.java
|  |  |              |─ InvalidTicTacToeSizeException.java
|  |  |              |─ NoWinnerException.java
|  |  |              |─ OutOfBoundsException.java
|  |  |              └─ SquareOccupiedException.java
|  |  └─ resources
|  |     └─ public
|  |        └─ index.html
|  └─ test
|     └─ java
|        └─ com
|           └─ swagfish
|              |─ server
|              |  └─ WebServerTest.java
|              └─ tictactoe
|                 └─ TicTacToeTest.java
|─ build.gradle
|─ gradlew
|─ gradlew.bat
|─ LICENSE.md
|─ Procfile
|─ README.md
|─ settings.gradle
|─ system.properties
|─ .git
|─ .gitignore
└─ .travis.yml
```

<a name="setup" />
## Setup
<a name="dl" />
### Download
```bash
$ git clone https://github.com/swagfish/tictactoe.git
```
<a name="cmp" />
### Compile
```bash
$ ./bin/compile
```
<a name="run" />
### Run
```bash
$ ./bin/deploy
```
<a name="all" />
### Clean, compile and run with all tests
```bash
$ ./bin/run_all
```