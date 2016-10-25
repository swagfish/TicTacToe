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
	public void NextToMoveTest3()
	{
		TicTacToe ttt = new TicTacToe();
		for (int i = 0; i < 2; i++) { 
			for (int j = 0; j < 3; j += 2) {
				ttt.add(i, j);
			}
		}
		assertEquals(1, ttt.getNextToMove());
	}
	@Test
	public void NextToMoveTest4()
	{
		TicTacToe ttt = new TicTacToe(10);
		for (int i = 0; i < 10; i++) ttt.add(0, i);
		assertEquals(1, ttt.getNextToMove());
	}
	@Test
	public void NextToMoveTest5()
	{
		TicTacToe ttt = new TicTacToe(10);
		for (int i = 0; i < 10; i++) ttt.add(0, i);
		assertEquals(1, ttt.getNextToMove());
	}
	@Test
	public void NextToMoveTest6()
	{
		TicTacToe ttt = new TicTacToe(10);
		for (int i = 0; i < 10; i++) {
			ttt.add(0, i);
			ttt.add(9, i);
		}
		ttt.add(4, 4);
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
	public void isOverTest4()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(1, 0);
		ttt.add(0, 1);
		ttt.add(1, 1);
		ttt.add(0, 2);
		ttt.add(1, 2);
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest5()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(0, 0);
		ttt.add(0, 1);
		ttt.add(1, 1);
		ttt.add(1, 0);
		ttt.add(2, 2);
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest6()
	{
		TicTacToe ttt = new TicTacToe();
		ttt.add(2, 0);
		ttt.add(0, 0);
		ttt.add(1, 1);
		ttt.add(0, 1);
		ttt.add(0, 2);
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest7()
	{
		TicTacToe ttt = new TicTacToe(10);
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) {
				ttt.add(i, j);
			}
		}
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest8()
	{
		TicTacToe ttt = new TicTacToe(10);
		for (int i = 0; i < 10; i += 2) 
		{
			for (int j = 0; j < 10; j += 2) {
				ttt.add(i, j);
			}
		}
		assertEquals(false, ttt.isOver());
	}
	@Test
	public void isOverTest9()
	{
		TicTacToe ttt = new TicTacToe(10);
		ttt.add(0, 0);
		ttt.add(0, 1);
		ttt.add(1, 1);
		ttt.add(0, 2);
		ttt.add(2, 2);
		ttt.add(0, 3);
		ttt.add(3, 3);
		ttt.add(0, 4);
		ttt.add(4, 4);
		ttt.add(0, 5);
		ttt.add(5, 5);
		ttt.add(0, 6);
		ttt.add(6, 6);
		ttt.add(0, 7);
		ttt.add(7, 7);
		ttt.add(0, 8);
		ttt.add(8, 8);
		ttt.add(0, 9);
		ttt.add(9, 9);
		assertEquals(true, ttt.isOver());
	}
	@Test
	public void isOverTest10()
	{
		TicTacToe ttt = new TicTacToe(10);
		ttt.add(9, 0);
		ttt.add(9, 1);
		ttt.add(8, 1);
		ttt.add(9, 2);
		ttt.add(7, 2);
		ttt.add(9, 3);
		ttt.add(6, 3);
		ttt.add(9, 4);
		ttt.add(5, 4);
		ttt.add(9, 5);
		ttt.add(4, 5);
		ttt.add(9, 6);
		ttt.add(3, 6);
		ttt.add(9, 7);
		ttt.add(2, 7);
		ttt.add(9, 8);
		ttt.add(1, 8);
		ttt.add(9, 9);
		ttt.add(0, 9);
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