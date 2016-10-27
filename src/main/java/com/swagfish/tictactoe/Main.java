package com.swagfish.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;


public class Main implements SparkApplication
{
	private TicTacToe ttt;

	public static void main(String[] args)
	{
		staticFileLocation("/public");
		SparkApplication web  = new Main();
		
		String port = System.getenv("PORT");
		if (port != null) port(Integer.valueOf(port));
		web.init();
	}


	private char handleRequest(int x, int y)
	{


		try
		{
			ttt.add(x,y);

		}
		catch(Exception ex)
		{

		}
		finally
		{
			try
			{
					return ttt.getSquare(x,y);
			}
			catch(Exception ex)
			{
				return ' ';
			}
		}
	}

	@Override
	public void init()
	{
		try{
			ttt = new TicTacToe();
		}catch(Exception ex){}

		get("/", (req, res) ->  {
			try{
				ttt = new TicTacToe();
			}catch(Exception ex){}
			return "";
		});
		post("/button1", (req, res) ->  handleRequest(0,0));
		post("/button2", (req, res) ->  handleRequest(0,1));
		post("/button3", (req, res) ->  handleRequest(0,2));
		post("/button4", (req, res) ->  handleRequest(1,0));
		post("/button5", (req, res) ->  handleRequest(1,1));
		post("/button6", (req, res) ->  handleRequest(1,2));
		post("/button7", (req, res) ->  handleRequest(2,0));
		post("/button8", (req, res) ->  handleRequest(2,1));
		post("/button9", (req, res) ->  handleRequest(2,2));
		post("/newgame", (req, res) ->  {
			try{
				ttt = new TicTacToe();
			}catch(Exception ex){}
			return " ";
		});
	}
}
