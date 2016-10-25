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

	public void add(int row, int column)
	{
		int index = getIndex(row, column);
		if (isOver() || map[index] != NONE) return; // throw new Exception(); // <-- replace with appr. exceptions
		map[index] = nextToMove;
		nextToMove = nextToMove == X ? O : X;
		winCheck();
	}



	private int getIndex(int row, int column)
	{
		return row * size + column;
	}

	private void winCheck()
	{
		// TODO
	}

}