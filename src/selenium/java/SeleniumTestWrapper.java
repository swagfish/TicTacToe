package com.swagfish.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;



public abstract class SeleniumTestWrapper
{
  static ChromeDriver driver;
  static String baseUrl;
  static String port;

  @BeforeClass
  public static void openBrowser()
  {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    /* For local testing
    System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
    baseUrl = "http://localhost:" + port;
    */

    // Testing the deployed version
    baseUrl = "https://arcane-tundra-47758.herokuapp.com/";
  }

  @AfterClass
  public static void closeBrowser()
  {
    driver.quit();
  }
}
