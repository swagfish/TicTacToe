package com.swagfish.tictactoe.exceptions;

public class SquareOccupiedException extends Exception {
	public SquareOccupiedException() {
		super();
	}
	public SquareOccupiedException(String msg) {
		super(msg);
	}
}