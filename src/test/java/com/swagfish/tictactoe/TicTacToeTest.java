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
	public void isOverTest()
	{
		assertEquals(false, new TicTacToe().isOver());
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
	public void WinnerTest1()
	{
		assertEquals(0, new TicTacToe().getWinner());
	}
}