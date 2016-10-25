package com.swagfish.tictactoe;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import com.swagfish.tictactoe.exceptions.*;

public class TicTacToeTest 
{
	@Test
	public void sizeTest1()
	{
		try 
		{
			assertEquals(3, new TicTacToe().getSize());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void sizeTest2()
	{
		try 
		{
			assertEquals(7, new TicTacToe(7).getSize());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		}
	}


	@Test
	public void NextToMoveTest1()
	{
		try 
		{
			assertEquals(1, new TicTacToe().getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void NextToMoveTest2()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(1, 1);
			assertEquals(-1, ttt.getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void NextToMoveTest3()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			for (int i = 0; i < 2; i++)
			{ 
				for (int j = 0; j < 3; j += 2)
				{
					ttt.add(i, j);
				}
			}
			assertEquals(1, ttt.getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void NextToMoveTest4()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i++)ttt.add(0, i);
			assertEquals(1, ttt.getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex) {
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void NextToMoveTest5()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i++)ttt.add(0, i);
			assertEquals(1, ttt.getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}

	@Test
	public void NextToMoveTest6()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i++)
			{
				if ((i & 0x1)== 0x1)
				{
					ttt.add(0, i);
					ttt.add(9, i);
				}
				else
				{
					ttt.add(9, i);
					ttt.add(0, i);
				}
			}
			ttt.add(4, 4);
			assertEquals(-1, ttt.getNextToMove());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}

	@Test
	public void isOverTest1()
	{
		try 
		{
			assertEquals(false, new TicTacToe().isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest2()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(1, 1);
			ttt.add(0, 0);
			ttt.add(0, 1);
			ttt.add(1, 0);
			ttt.add(2, 1);
			assertEquals(true, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest3()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 0);	
			ttt.add(1, 0);
			ttt.add(1, 1);
			ttt.add(1, 2);
			ttt.add(2, 0);
			assertEquals(false, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest4()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(1, 0);
			ttt.add(0, 1);
			ttt.add(1, 1);
			ttt.add(0, 2);
			ttt.add(1, 2);
			assertEquals(true, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest5()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 0);
			ttt.add(0, 1);
			ttt.add(1, 1);
			ttt.add(1, 0);
			ttt.add(2, 2);
			assertEquals(true, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	
	@Test
	public void isOverTest6()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(2, 0);
			ttt.add(0, 0);
			ttt.add(1, 1);
			ttt.add(0, 1);
			ttt.add(0, 2);
			assertEquals(true, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest7()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i++)
			{
				ttt.add(i, 9 - i);
				if (i != 9)ttt.add(9, i + 1);
			}
			assertEquals(true, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex)
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex)
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex)
		 {
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest8()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i += 2)
			{
				for (int j = 0; j < 10; j += 2)
				{
					ttt.add(i, j);
				}
			}
			assertEquals(false, ttt.isOver());
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest9()
	{
		try 
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
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test
	public void isOverTest10()
	{
		try 
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
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}

	@Test 
	public void winnerTest1()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 0);
			ttt.add(0, 1);
			ttt.add(1, 1);
			ttt.add(1, 0);
			ttt.add(2, 2);
			assertEquals(1, ttt.getWinner());
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (NoWinnerException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test 
	public void winnerTest2()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 2);
			ttt.add(0, 1);
			ttt.add(1, 2);
			ttt.add(1, 0);
			ttt.add(2, 2);
			assertEquals(1, ttt.getWinner());
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (NoWinnerException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test 
	public void winnerTest3()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 0);
			ttt.add(1, 0);
			ttt.add(2, 0);
			ttt.add(1, 1);
			ttt.add(2, 2);
			ttt.add(1, 2);
			assertEquals(-1, ttt.getWinner());
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (NoWinnerException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test 
	public void winnerTest4()
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(10);
			for (int i = 0; i < 10; i++)
			{
				ttt.add(9 - i, i);
				if (i != 9) ttt.add(0, i);
			}
			assertEquals(1, ttt.getWinner());
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (NoWinnerException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex)
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}

	@Test(expected = InvalidTicTacToeSizeException.class)
	public void sizeExceptionTest1() throws InvalidTicTacToeSizeException 
	{
		new TicTacToe(0);
	}
	@Test(expected = InvalidTicTacToeSizeException.class)
	public void sizeExceptionTest2() throws InvalidTicTacToeSizeException 
	{
		new TicTacToe(-5);
	}
	@Test(expected = InvalidTicTacToeSizeException.class)
	public void sizeExceptionTest3() throws InvalidTicTacToeSizeException 
	{
		new TicTacToe(50);
	}

	@Test(expected = NoWinnerException.class)
	public void noWinnerExceptionTest1() throws NoWinnerException 
	{
		try 
		{
			new TicTacToe().getWinner();
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = NoWinnerException.class)
	public void noWinnerExceptionTest2() throws NoWinnerException 
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(5);
			ttt.add(0, 0);
			ttt.add(0, 3);
			ttt.add(0, 1);
			ttt.add(0, 4);
			ttt.add(0, 2);
			ttt.getWinner();
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = NoWinnerException.class)
	public void noWinnerExceptionTest3() throws NoWinnerException 
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(0, 2);
			ttt.add(1, 1);
			ttt.add(1, 2);
			ttt.add(0, 1);
			ttt.add(2, 0);			
			ttt.add(1, 0);
			ttt.add(0, 0);
			ttt.add(2, 2);
			ttt.add(2, 1);
			ttt.getWinner();
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}

	@Test(expected = OutOfBoundsException.class)
	public void outOfBoundsExceptionTest1() throws OutOfBoundsException 
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(-5, 0);
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = OutOfBoundsException.class)
	public void outOfBoundsExceptionTest2() throws OutOfBoundsException 
	{
		try 
		{
			TicTacToe ttt = new TicTacToe();
			ttt.add(2, 1);
			ttt.add(5, 0);
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = OutOfBoundsException.class)
	public void outOfBoundsExceptionTest3() throws OutOfBoundsException 
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(8);
			ttt.add(0, 0);
			ttt.add(8, 8);
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		} 
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
	}

	@Test(expected = SquareOccupiedException.class)
	public void squareOccupiedException1() throws SquareOccupiedException
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(8);
			ttt.add(0, 0);
			ttt.add(0, 0);
		} 
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = SquareOccupiedException.class)
	public void squareOccupiedException2() throws SquareOccupiedException
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(3);
			ttt.add(0, 0);
			ttt.add(1, 1);
			ttt.add(2, 0);
			ttt.add(1, 1);
		}
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (AlreadyOverException ex) 
		{
			assertEquals(0, 1);
		}
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		}
	}

	@Test(expected = AlreadyOverException.class)
	public void alreadyOverException1() throws AlreadyOverException
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(3);
			ttt.add(0, 0);
			ttt.add(1, 1);
			ttt.add(2, 0);
			ttt.add(1, 2);
			ttt.add(1, 0);
			ttt.add(2, 2);
		}
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		}
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		}
	}
	@Test(expected = AlreadyOverException.class)
	public void alreadyOverException2() throws AlreadyOverException
	{
		try 
		{
			TicTacToe ttt = new TicTacToe(5);
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 5; j++)
				{
					ttt.add(i, j);
				}
			}
		}
		catch (InvalidTicTacToeSizeException ex) 
		{
			assertEquals(0, 1);
		}
		catch (OutOfBoundsException ex) 
		{
			assertEquals(0, 1);
		}
		catch (SquareOccupiedException ex) 
		{
			assertEquals(0, 1);
		}
	}
}