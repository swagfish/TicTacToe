package com.swagfish.tictactoe.exceptions;

public class NoWinnerException extends Exception {
	public NoWinnerException() {
		super();
	}
	public NoWinnerException(String msg) {
		super(msg);
	}
}