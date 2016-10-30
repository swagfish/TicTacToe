package com.swagfish.server;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;
import com.swagfish.tictactoe.TicTacToe;
import com.swagfish.tictactoe.exceptions.*;

/**
 * <h1>TicTacToe Web Server</h1>
 * The web server that handles the client requests.
 * It updates the game and keeps track of the current state.
 *
 * @author teamSwagFish
 * @version 1.0
 * @since 2016-10-20
 * @serial SWAG-FISH-INC
 */
public class WebServer implements SparkApplication
{
	private TicTacToe ttt;

	/**
	 * The main function. Connects the java application to the server
	 * @param args Unused input string
	 */
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

	/**
	 * Initializes the game.
	 * Creates a new map to be played and listens
	 * to when the new game button is pushed.
	 */
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

	/**
	 * Handles requests from the client
	 * @param index The index of square
	 * @return char The player
	 */
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

	/**
	 * Helper function for the handleRequest function
	 * returns the char (' ' if none) that should occupy the square
	 * @param index The index of square
	 * @throws OutOfBoundsException The move is illegal
	 * @return char The player
	 */
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

	/**
	 * Returns results, if any (empty string on none finished games)
	 * @return String The winner
	 */
	private String displayWinner()
	{
		try
		{
			return ttt.getWinner() == 1 ? "X wins" : "O wins";
		}
		catch (NoWinnerException ex)
		{
			return ttt.isOver() ? "draw" : "";
		}
	}
}
