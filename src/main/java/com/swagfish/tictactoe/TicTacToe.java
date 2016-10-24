package com.swagfish.tictactoe;

public class TicTacToe
{
	private static final byte EMPTY = 0;
	private static final byte X = 1;
	private static final byte O = -1;
	
	private byte[] map;
	private int size;
	private byte nextToMove;

	public TicTacToe()
	{
		this(3);
	}
	public TicTacToe(int size)
	{
		this.size = size;
		map = new byte[size << 1];
		nextToMove = X;
	}


	public int getSize()
	{
		return size;
	}

}