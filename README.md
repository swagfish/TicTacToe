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
[![Code Coverage](https://img.shields.io/codecov/c/gh/swagfish/TicTacToe/develop.svg)](https://codecov.io/gh/swagfish/TicTacToe?branch=develop)

<a name="play" />
## Play
[Our game's continuous delivery](https://arcane-tundra-47758.herokuapp.com/ "TicTacToe")

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
|─ gradle
|─ docs
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
|  |        |─ backgr.jpg
|  |        |─ index.html
|  |        |─ style.css
|  |        └─ ttt.js
|  |─ selenium
|  |  └─ java
|  |     |─ SeleniumTestWrapper.java
|  |     └─ TestTicTacToe.java
|  └─ test
|     └─ java
|        └─ com
|           └─ swagfish
|              |─ server
|              |  └─ WebServerTest.java
|              └─ tictactoe
|                 └─ TicTacToeTest.java
|─ .gitignore
|─ .travis.yml
|─ build.gradle
|─ gradlew
|─ gradlew.bat
|─ phantomjsdriver.log
|─ Procfile
|─ README.md
|─ settings.gradle
└─ system.properties
```

<a name="setup" />
## Setup
The following scripts will compile, run tests and deploy the program. To play it, open localhost:4567 in a browser.
### Download
```bash
$ git clone https://github.com/swagfish/tictactoe.git
```
### Unix
```bash
$ ./bin/run_all
```
### Windows
```bat
$ bin\run_all.bat
```
