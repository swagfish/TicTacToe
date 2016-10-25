package com.swagfish.tictactoe.exceptions;

public class InvalidTicTacToeSizeException extends Exception {
	public InvalidTicTacToeSizeException() {
		super();
	}
	public InvalidTicTacToeSizeException(String msg) {
		super(msg);
	}
}