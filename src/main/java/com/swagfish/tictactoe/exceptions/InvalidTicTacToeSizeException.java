package com.swagfish.tictactoe.exceptions;

/**
 * The InvalidTicTacToeSizeException exception is thrown when 
 * map is trying to be made with an invalid size.
 * It is a simple exception that extends the basic Exception class
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class InvalidTicTacToeSizeException extends Exception {
	
	/**
	 * The default constructor for InvalidTicTacToeSizeException
	 */
	public InvalidTicTacToeSizeException() {
		super();
	}
	
	/**
	 * The constructor for InvalidTicTacToeSizeException with a message
	 * @param msg The message that follows the exception
	 */
	public InvalidTicTacToeSizeException(String msg) {
		super(msg);
	}
}