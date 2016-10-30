package com.swagfish.tictactoe.exceptions;

/**
 * The SquareOccupiedException exception is thrown when a play 
 * is trying to be made but the chosen square is occupied.
 * It is a simple exception that extends the basic Exception class
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class SquareOccupiedException extends Exception {
	
	/**
	 * The default constructor for SquareOccupiedException
	 */
	public SquareOccupiedException() {
		super();
	}
	
	/**
	 * The constructor for SquareOccupiedException with a message
	 * @param msg The message that follows the exception
	 */
	public SquareOccupiedException(String msg) {
		super(msg);
	}
}