package com.swagfish.tictactoe;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;

public class TicTacToeTest 
{
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
}