package com.swagfish.tictactoe;

import com.swagfish.tictactoe.exceptions.*;

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

	public TicTacToe() throws InvalidTicTacToeSizeException
	{
		this(3);
	}
	public TicTacToe(int size) throws InvalidTicTacToeSizeException
	{
		if (size < MIN_SIZE || size > MAX_SIZE) throw new InvalidTicTacToeSizeException();
		this.size = size;
		map = new byte[size * size];
		nextToMove = X;
		movesLeft = map.length;
	}
	public int getSize()
	{
		return size;
	}	
	public byte getNextToMove()
	{
		return nextToMove;
	}
	public boolean isOver()
	{
		return isOver;
	}
	public byte getWinner() throws NoWinnerException
	{
		if (winner == NONE) throw new NoWinnerException();
		return winner; 
	}
	public void add(int row, int column) throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		add(row, column, getIndex(row, column));
	}
	public void add(int index) throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		add(getRow(index), getColumn(index), index);
	}
	// TODO: Tests
	public char getSquare(int index) throws OutOfBoundsException
	{
		if (isOutOfBounds(index)) throw new OutOfBoundsException();
		return map[index] == 0 ? ' ' : (map[index] == 1 ? 'X' : 'O');
	}
	// TODO: Tests
	public char getSquare(int row, int column) throws OutOfBoundsException
	{
		return getSquare(getIndex(row, column));
	}

	private void add(int row, int column, int index)  throws OutOfBoundsException, SquareOccupiedException, AlreadyOverException
	{
		if (isOver) throw new AlreadyOverException();
		if (isOutOfBounds(row, column)) throw new OutOfBoundsException();
		if (map[index] != NONE) throw new SquareOccupiedException();

		movesLeft--;
		map[index] = nextToMove;
		if (movesLeft == 0) 
		{
			isOver = true;
			return;
		}
		winCheck(nextToMove, row, column, index);
		nextToMove = nextToMove == X ? O : X;
	}
	private int getRow(int index)
	{
		return index / size;
	}
	private int getColumn(int index)
	{
		return index % size;
	}
	private int getIndex(int row, int column)
	{
		return row * size + column;
	}
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
	private boolean isOutOfBounds(int row, int column)
	{
		return row < 0 || row >= size || column < 0 || column >= size;
	}
	private boolean isOutOfBounds(int index)
	{
		return index < 0 || index >= map.length;
	}
	private boolean isOnNorthWestSouthEastDiagonal(int row, int column)
	{
		return row == column;
	}
	private boolean winOnNorthWestSouthEastDiagonal(byte match)
	{
		for (int i = 0; i < size * size; i += size + 1)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
	private boolean isOnNorthEastSouthWestDiagonal(int row, int column)
	{
		return (row == size - 1 && column == 0) || (size - 1 - row == column);
	}
	private boolean winOnNorthEastSouthWestDiagonal(byte match)
	{
		for (int i = size - 1; i < size * size - 1; i += size - 1)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
	private boolean winOnHorizontal(int index, byte match)
	{
		int min = (index / size) * size;
		for (int i = min; i < min + size; i++)
		{
			if (map[i] != match) return false;
		}
		return true;
	}
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