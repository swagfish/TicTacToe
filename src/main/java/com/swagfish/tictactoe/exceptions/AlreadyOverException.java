package com.swagfish.tictactoe.exceptions;

public class AlreadyOverException extends Exception {
	public AlreadyOverException() {
		super();
	}
	public AlreadyOverException(String msg) {
		super(msg);
	}
}