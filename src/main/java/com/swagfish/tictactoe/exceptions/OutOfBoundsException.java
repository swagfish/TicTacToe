package com.swagfish.tictactoe.exceptions;

public class OutOfBoundsException extends Exception {
	public OutOfBoundsException() {
		super();
	}
	public OutOfBoundsException(String msg) {
		super(msg);
	}
}