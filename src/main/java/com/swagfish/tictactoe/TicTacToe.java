package com.swagfish.tictactoe;



public class TicTacToe
{
	// TODO: Create custom exception or throw more apprioriate ones


	private static final byte NONE = 0;
	private static final byte X = 1;
	private static final byte O = -1;

	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 10;
	
	private byte[] map;
	private int size;
	private byte nextToMove;
	private boolean isOver;

	public TicTacToe()
	{
		this(3);
	}
	public TicTacToe(int size)
	{
		//if (size < MIN_SIZE || size > MAX_SIZE) throw new Exception();
		this.size = size;
		map = new byte[size << 1];
		nextToMove = X;
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
	public byte getWinner()
	{
		return !isOver() ? NONE : (nextToMove == O ? X : O);
	}



	public byte getSymbol(int row, int column)
	{
		// TODO: ERROR HANDLING
		return map[getIndex(row, column)];
	}
	public void add(int row, int column)
	{
		int index = getIndex(row, column);
		//if (isOver() || map[index] != NONE) return; // throw new Exception(); // <-- replace with appr. exceptions
		//TODO: also add OOB checks for row/col
		map[index] = nextToMove;
		winCheck(nextToMove, row, column, index);
		nextToMove = nextToMove == X ? O : X;
	}



	private int getIndex(int row, int column)
	{
		return row * size + column;
	}

	private void winCheck(byte lastToMove, int row, int column, int index)
	{
		if (isOnNorthWestSouthEastDiagonal(row, column) && winOnNorthWestSouthEastDiagonal(lastToMove))
		{
			isOver = true;
			return;
		}
		if (isOnNorthEastSouthWestDiagonal(row, column) && winOnNorthEastSouthWestDiagonal(lastToMove))
		{
			isOver = true;
			return;
		}
		if (winOnHorizontal(index, lastToMove))
		{
			isOver = true;
			return;
		}
		if (winOnVertical(index, lastToMove))
		{
			isOver = true;
			return;
		}
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

	public String toString()
	{
		StringBuilder retVal = new StringBuilder();
		for (int i = 0; i < size * size;)
		{
			for (int j = 0; j < size; j++, i++)
			{
				retVal.append('[');
				retVal.append(map[i] == NONE ? ' ' : (map[i] == X ? 'X' : 'O'));
				retVal.append(']');
			}
			retVal.append('\n');
		}
		return retVal.substring(0, retVal.length() - 1);
	}
}