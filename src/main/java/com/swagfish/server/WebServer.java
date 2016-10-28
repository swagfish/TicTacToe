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
		// path of html files
		staticFileLocation("/public");

		// new instance of webserv
		SparkApplication web  = new WebServer();

		// set poort
		String port = System.getenv("PORT");
		if (port != null) port(Integer.valueOf(port));

		// setup server listeners
		web.init();
	}

	@Override
	public void init()
	{
		// Create new game on start
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

		// Handle each square of the game
		post("/button1", (req, res) ->  handleRequest(0));
		post("/button2", (req, res) ->  handleRequest(1));
		post("/button3", (req, res) ->  handleRequest(2));
		post("/button4", (req, res) ->  handleRequest(3));
		post("/button5", (req, res) ->  handleRequest(4));
		post("/button6", (req, res) ->  handleRequest(5));
		post("/button7", (req, res) ->  handleRequest(6));
		post("/button8", (req, res) ->  handleRequest(7));
		post("/button9", (req, res) ->  handleRequest(8));

		// On each call, we display the winner, if any
		post("/getwinner", (req, res) -> displayWinner());

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

	// error handler for handlerequesthelper which calls add() in ttt
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

	// returns the char (' ' if none) that should occupy the square
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

	// Returns results, if any (empty string on none finished games)
	private String displayWinner()
	{
		try 
		{
			return ttt.getWinner() == 1 ? "X wins" : "O wins";
		}
		catch (NoWinnerException ex)
		{
			return "";
		}
	}
}