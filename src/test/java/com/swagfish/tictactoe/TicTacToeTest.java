package com.swagfish.tictactoe;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;

public class TicTacToeTest 
{
	// TODO: Test exceptions

	@Test
	public void sizeTest1() 
	{
		assertEquals(3, new TicTacToe().getSize());
	}

	@Test
	public void sizeTest2() 
	{
		assertEquals(12, new TicTacToe(12).getSize());
	}

	@Test
	public void NextToMoveTest1()
	{
		assertEquals(1, new TicTacToe().getNextToMove());
	}

	@Test
	public void NextToMoveTest2()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 1);
		assertEquals(-1, ttt.getNextToMove());
	}

	@Test
	public void isOverTest1()
	{
		assertEquals(false, new TicTacToe().isOver());
	}
	@Test
	public void isOverTest2()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 1);
		ttt.add(0, 0);
		ttt.add(0, 1);
		ttt.add(1, 0);
		ttt.add(2, 1);
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest3()
	{
		TicTacToe ttt = new TicTacToe();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ttt.add(i, j);
			}
		}
		assertEquals(true, ttt.isOver());
	}

	@Test
	public void alternatingPlayersTest()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 1);
		assertEquals(-1, ttt.getNextToMove());
	}

	@Test 
	public void mapUpdateTest1()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 1);
		assertEquals(1, ttt.getSymbol(1,1));
	}
	@Test 
	public void mapUpdateTest2()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 1);
		ttt.add(0, 0);
		assertEquals(-1, ttt.getSymbol(0, 0));
	}
	@Test 
	public void mapUpdateTest3()
	{
		TicTacToe ttt = new TicTacToe();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ttt.add(i, j);
			}
		}
		assertEquals(1, ttt.getSymbol(2, 2));
	}


	@Test 
	public void WinnerTest1()
	{
		assertEquals(0, new TicTacToe().getWinner());
	}
	@Test 
	public void WinnerTest2()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(0, 0);
		ttt.add(0, 1);
		ttt.add(1, 2);
		ttt.add(1, 0);
		ttt.add(2, 2);
		assertEquals(1, ttt.getSymbol(2, 2));
	}
}