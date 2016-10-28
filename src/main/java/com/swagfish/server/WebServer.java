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
		staticFileLocation("/public");
		SparkApplication web  = new WebServer();		
		String port = System.getenv("PORT");
		if (port != null) port(Integer.valueOf(port));
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
		try
		{
			ttt = new TicTacToe();
		}
		catch(InvalidTicTacToeSizeException ex) { }

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

		post("/button1", (req, res) ->  handleRequest(0));
		post("/button2", (req, res) ->  handleRequest(1));
		post("/button3", (req, res) ->  handleRequest(2));
		post("/button4", (req, res) ->  handleRequest(3));
		post("/button5", (req, res) ->  handleRequest(4));
		post("/button6", (req, res) ->  handleRequest(5));
		post("/button7", (req, res) ->  handleRequest(6));
		post("/button8", (req, res) ->  handleRequest(7));
		post("/button9", (req, res) ->  handleRequest(8));

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
}