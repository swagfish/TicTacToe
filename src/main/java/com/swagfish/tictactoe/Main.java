package com.swagfish.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;


public class Main implements SparkApplication 
{
	public static void main(String[] args) 
	{
		staticFileLocation("/public");
		SparkApplication web  = new Main();

		String port = System.getenv("PORT");
		if (port != null) port(Integer.valueOf(port));
		web.init();

		
	}
	@Override
	public void init()
	{
		get("/index.html", (req, res) -> "");
	}
}
