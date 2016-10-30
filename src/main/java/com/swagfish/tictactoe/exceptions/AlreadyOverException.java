package com.swagfish.tictactoe.exceptions;

/**
 * The AlreadyOverException exception is thrown when a play 
 * is trying to be made but the game has finished.
 * It is a simple exception that extends the basic Exception class
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class AlreadyOverException extends Exception {
	
	/**
	 * The default constructor for AlreadyOverException
	 */
	public AlreadyOverException() {
		super();
	}
	
	/**
	 * The constructor for AlreadyOverException with a message
	 * @param msg The message that follows the exception
	 */
	public AlreadyOverException(String msg) {
		super(msg);
	}
}