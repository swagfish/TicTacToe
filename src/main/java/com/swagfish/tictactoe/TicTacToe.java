package com.swagfish.tictactoe;

import com.swagfish.tictactoe.exceptions.*;

/**
 * <h1>TicTacToe</h1>
 * The TicTacToe class implements a video game that
 * two players can play at a time. The API can be integrated
 * and used for any platform.
 * 
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */

public class TicTacToe
{
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 10;
	private static final byte NONE = 0;
	private static final byte X = 1;
	private static final byte O = -1;
	
	private byte[] map;
	private int size;
	private byte nextToMove;
	private boolean isOver;
	private int movesLeft;
	private byte winner;

	/**
	 * The default constructor does not approve of no value
	 * being passed in, therefore throwing an exception and
	 * generating the default map (of size 3)
	 * 
	 * @throws InvalidTicTacToeSizeException You should initialize with a value
	 */
	public TicTacToe() throws InvalidTicTacToeSizeException
	{
		this(3);
	}

	/**
	 * The constructor initializes the map for TicTacToe.
	 * Accepted values are between 3 and 10.
	 * @param size This is the only parameter and sets the map size
	 * @throws InvalidTicTacToeSizeException Invalid size of map
	 */
	public TicTacToe(int size) throws InvalidTicTacToeSizeException
	{
		if (size < MIN_SIZE || size > MAX_SIZE) throw new InvalidTicTacToeSizeException();
		this.size = size;
		map = new byte[size * size];
		nextToMove = X;
		movesLeft = map.length;
	}/**
	 * Returns the size of the map
	 * @return int The size of the map
	 */
	public int getSize()
	{
		return size;
	}	

	/**
	 * Returns the character of which player 
	 * will make the next move
	 * @return byte The next player
	 */
	public byte getNextToMove()
	{
		return nextToMove;
	}
	
	/**
	 * Returns true if the game is over,
	 * false otherwise
	 * @return boolean Is the game finished?
	 */
	public boolean isOver()
	{
		return isOver;
	}
	
	/**
	 * Returns the character of which player
	 * won the game.
	 * @return byte The character of the winner
	 * @throws NoWinnerException There is no winner
	 */
	public byte getWinner() throws NoWinnerException
	{
		if (winner == NONE) throw new NoWinnerException();
		return winner; 
	}
	
	/**
	 * Add a symbol to the right place
	 * @param row The row
	 * @param column The column
	 * @throws OutOfBoundsException Out of bounds
	 * @throws SquareOccupiedException The square is occupied
	 * @throws AlreadyOverException Game is already over
	 */

	public void add(int row, int column) throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		add(row, column, getIndex(row, column));
	}

	/**
	 * Add a symbol to the right place
	 * @param index The place where the symbol should be placed
	 * @throws OutOfBoundsException Out of bounds
	 * @throws SquareOccupiedException The square is occupied
	 * @throws AlreadyOverException Game is already over
	 */
	public void add(int index) throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		add(getRow(index), getColumn(index), index);
	}
	// TODO: Tests

	/**
	 * Add a symbol to the right place
	 * @param index The place where the symbol should be placed
	 * @throws OutOfBoundsException Out of bounds
	 * @return char Returns what is in the square
	 */
	public char getSquare(int index) throws OutOfBoundsException
	{
		if (isOutOfBounds(index)) throw new OutOfBoundsException();
		return map[index] == 0 ? ' ' : (map[index] == 1 ? 'X' : 'O');
	}
	// TODO: Tests

	/**
	 * Add a symbol to the right place
	 * @param row The row
	 * @param column The column
	 * @throws OutOfBoundsException Out of bounds
	 * @return char Returns what is in the square
	 */
	public char getSquare(int row, int column) throws OutOfBoundsException
	{
		return getSquare(getIndex(row, column));
	}

	/**
	 * Add a symbol to the right place
	 * @param row The row
	 * @param column The column
	 */
	private void add(int row, int column, int index)  throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		if (isOver) throw new AlreadyOverException();
		if (isOutOfBounds(row, column)) throw new OutOfBoundsException();
		if (map[index] != NONE) throw new SquareOccupiedException();

		movesLeft--;
		map[index] = nextToMove;
		winCheck(nextToMove, row, column, index);
		if (movesLeft == 0) 
		{
			isOver = true;
			return;
		}
		nextToMove = nextToMove == X ? O : X;
	}

	/**
	 * Returns the row at given index
	 * @param index The row index
	 * @return int The row
	 */
	private int getRow(int index)
	{
		return index / size;
	}
	
	/**
	 * Returns the row at given index
	 * @param index The row index
	 * @return int The row
	 */
	private int getColumn(int index)
	{
		return index % size + 1;
	}
	
	/**
	 * Returns the index at given row and column
	 * @param row The row
	 * @param column The column
	 * @return int The index
	 */
	private int getIndex(int row, int column)
	{
		return row * size + column;
	}
	
	/**
	 * Performs a check on whether a player has won.
	 * @param lastToMove The last player
	 * @param row The row
	 * @param column The column
	 * @param index The index
	 */
	private void winCheck(byte lastToMove, int row, int column, int index)
	{
		if ((isOnNorthWestSouthEastDiagonal(row, column) && winOnNorthWestSouthEastDiagonal(lastToMove)) ||
			(isOnNorthEastSouthWestDiagonal(row, column) && winOnNorthEastSouthWestDiagonal(lastToMove)) ||
			(winOnHorizontal(index, lastToMove)) ||
			(winOnVertical(index, lastToMove)))
		{
			isOver = true;
			winner = lastToMove;
			return;
		}
	}

	/**
	 * Returns true if out of bounds, false otherwise
	 * @param row The row
	 * @param column The column
	 * @return boolean True if out of bounds, false otherwise
	 */
	private boolean isOutOfBounds(int row, int column)
	{
		return row < 0 || row >= size || column < 0 || column >= size;
	}
	
	/**
	 * Returns true if out of bounds, false otherwise
	 * @param index The index
	 * @return boolean True if out of bounds, false otherwise
	 */
	private boolean isOutOfBounds(int index)
	{
		return index < 0 || index >= map.length;
	}
	
	/**
	 * Returns true if is on NW SE Diagonal, false otherwise
	 * @param row The row
	 * @param column The column
	 * @return boolean True if is on NW SE Diagonal, false otherwise
	 */
	private boolean isOnNorthWestSouthEastDiagonal(int row, int column)
	{
		return row == column;
	}
	
	/**
	 * Returns true if win on NW SE Diagonal, false otherwise
	 * @param match The char of the player
	 * @return boolean True if win on NW SE Diagonal, false otherwise
	 */
	private boolean winOnNorthWestSouthEastDiagonal(byte match)
	{
		for (int i = 0; i < size * size; i += size + 1)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
	
	/**
	 * Returns true if is on NE SW Diagonal, false otherwise
	 * @param row The row
	 * @param column The column
	 * @return boolean True if is on NE SW Diagonal, false otherwise
	 */
	private boolean isOnNorthEastSouthWestDiagonal(int row, int column)
	{
		return (row == size - 1 && column == 0) || (size - 1 - row == column);
	}
	
	/**
	 * Returns true if win on NE SW Diagonal, false otherwise
	 * @param match The char of the player
	 * @return boolean True if win on NE SW Diagonal, false otherwise
	 */
	private boolean winOnNorthEastSouthWestDiagonal(byte match)
	{
		for (int i = size - 1; i < size * size - 1; i += size - 1)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
	
	/**
	 * Returns true if win on horizontal, false otherwise
	 * @param index The index
	 * @param match The player
	 * @return boolean True if win on horizontal, false otherwise
	 */
	private boolean winOnHorizontal(int index, byte match)
	{
		int min = (index / size) * size;
		for (int i = min; i < min + size; i++)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
	
	/**
	 * Returns true if win on vertical, false otherwise
	 * @param index The index
	 * @param match The player
	 * @return boolean True if win on vertical, false otherwise
	 */
	private boolean winOnVertical(int index, byte match)
	{
		int min = (index % size);
		for (int i = min; i < size * size; i += size)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
}
