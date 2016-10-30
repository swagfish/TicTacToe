package com.swagfish.tictactoe.exceptions;

/**
 * The OutOfBoundsException exception is thrown when a play 
 * is trying to be made but the square is out of the map.
 * It is a simple exception that extends the basic Exception class
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class OutOfBoundsException extends Exception {
	
	/**
	 * The default constructor for OutOfBoundsException
	 */
	public OutOfBoundsException() {
		super();
	}
	
	/**
	 * The constructor for OutOfBoundsException with a message
	 * @param msg The message that follows the exception
	 */
	public OutOfBoundsException(String msg) {
		super(msg);
	}
}