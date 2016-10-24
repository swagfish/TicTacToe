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
		get("/gettest", (req, res) -> "gettest");

		// TODO: use library to make JSon objects
		post("/signin", (req, res) -> {
		    return String.format("{username:%s, password:%s}", 
		    	req.queryParams("username"), 
		    	req.queryParams("password"));
		});
		post("/signup", (req, res) -> {
			return String.format("{username:%s, password:%s, confirm_password:%s}", 
				req.queryParams("username"), 
				req.queryParams("password"), 
				req.queryParams("confirm_password"));
		});
	}
}
