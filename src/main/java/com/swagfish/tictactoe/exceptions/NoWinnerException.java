package com.swagfish.tictactoe.exceptions;

/**
 * The NoWinnerException exception is thrown when there is no
 * winner found, but the game is over.
 * It is a simple exception that extends the basic Exception class
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class NoWinnerException extends Exception {
	
	/**
	 * The default constructor for NoWinnerException
	 */
	public NoWinnerException() {
		super();
	}
	
	/**
	 * The constructor for NoWinnerException with a message
	 * @param msg The message that follows the exception
	 */
	public NoWinnerException(String msg) {
		super(msg);
	}
}