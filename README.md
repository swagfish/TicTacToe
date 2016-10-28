# TicTacToe

Master:[![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=master)](https://travis-ci.org/swagfish/TicTacToe)
Develop:[![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=develop)](https://travis-ci.org/swagfish/TicTacToe)

![Heroku](https://heroku-badge.herokuapp.com/?app=arcane-tundra-47758)

[![Code Coverage](https://img.shields.io/codecov/c/github/pvorb/property-providers/develop.svg)](https://codecov.io/github/pvorb/property-providers?branch=develop)

Table of contents
=================

  * [Play!](#Play)
  * [Website](#Project website)
  * [Project structure](#Project structure)

# Play
[Swagfish represents TicTacToe](https://arcane-tundra-47758.herokuapp.com/ "TicTacToe")

# Project website
[Visit our website](https://swagfish.github.io/TicTacToe/)

# Project structure
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
