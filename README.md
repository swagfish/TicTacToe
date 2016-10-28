# TicTacToe

Table of contents
=================

  * [Master](#master)
  * [Develop](#develop)
  * [Heroku Deployment](#heroku-deployment)

## Master
[![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=master)](https://travis-ci.org/swagfish/TicTacToe)

## Develop
[![Build Status](https://travis-ci.org/swagfish/TicTacToe.svg?branch=develop)](https://travis-ci.org/swagfish/TicTacToe)

## Heroku Deployment
[TicTacToe](https://arcane-tundra-47758.herokuapp.com/ "TicTacToe")

## Code Coverage
[![Code Coverage](https://img.shields.io/codecov/c/github/pvorb/property-providers/develop.svg)](https://codecov.io/github/pvorb/property-providers?branch=develop)

### Project Structure
```
root
└─ bin
   └─ check_code.sh
   └─ clean.sh
   └─ compile.sh
   └─ deploy.sh
   └─ package.sh
   └─ run_all.sh
   └─ unit_test.sh
└─ gradle
└─ src
   └─ main
      └─ java
         └─ com
            └─ swagfish
               └─ server
                  └─ WebServer.java
               └─ tictactoe
                  └─ TicTacToe.java
                  └─ exceptions
                     └─ AlreadyOverException.java
                     └─ InvalidTicTacToeSizeException.java
                     └─ NoWinnerException.java
                     └─ OutOfBoundsException.java
                     └─ SquareOccupiedException.java
      └─ resources
         └─ public
            └─ index.html
   └─ test
      └─ java
         └─ com
            └─ swagfish
               └─ server
                  └─ WebServerTest.java
               └─ tictactoe
                  └─ TicTacToeTest.java
└─ build.gradle
└─ gradlew
└─ gradlew.bat
└─ LICENSE.md
└─ Procfile
└─ README.md
└─ settings.gradle
└─ system.properties
└─ .gitignore
└─ .travis.yml
```