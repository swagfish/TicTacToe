package com.swagfish.server;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;
import com.swagfish.tictactoe.TicTacToe;
import com.swagfish.tictactoe.exceptions.*;


public class WebServer implements SparkApplication
{
	private TicTacToe ttt;

	public static void main(String[] args)
	{
		staticFileLocation("/public");
		SparkApplication web  = new WebServer();		
		String port = System.getenv("PORT");
		if (port != null) port(Integer.valueOf(port));
		web.init();
	}

	@Override
	public void init()
	{
		try
		{
			ttt = new TicTacToe();
		}
		catch(InvalidTicTacToeSizeException ex) { }

		// NEW GAME WHEN REFRESHED
		get("/", (req, res) ->  {
			try
			{
				ttt = new TicTacToe();
				res.status(200);
			}
			catch(InvalidTicTacToeSizeException ex) 
			{
				res.status(400);
			}
			return "";
		});

		// Handle ttt squares
		post("/button1", (req, res) ->  handleRequest(0));
		post("/button2", (req, res) ->  handleRequest(1));
		post("/button3", (req, res) ->  handleRequest(2));
		post("/button4", (req, res) ->  handleRequest(3));
		post("/button5", (req, res) ->  handleRequest(4));
		post("/button6", (req, res) ->  handleRequest(5));
		post("/button7", (req, res) ->  handleRequest(6));
		post("/button8", (req, res) ->  handleRequest(7));
		post("/button9", (req, res) ->  handleRequest(8));

		// Handle new game button
		post("/newgame", (req, res) ->  {
			try
			{
				ttt = new TicTacToe();
				res.status(200);
			}
			catch(InvalidTicTacToeSizeException ex) 
			{ 
				res.status(400);
			}
			return "";
		});
	}

	private char handleRequest(int index)
	{
		try
		{
			return handleRequestHelper(index);
		}
		catch (OutOfBoundsException e)
		{
			return ' ';
		}
	}
	private char handleRequestHelper(int index) throws OutOfBoundsException
	{
		try
		{
			ttt.add(index);
		}
		catch (SquareOccupiedException ex) { }
		catch (AlreadyOverException ex) { }
		return ttt.getSquare(index);
	}
}