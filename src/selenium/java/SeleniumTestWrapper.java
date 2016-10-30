package com.swagfish.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class SeleniumTestWrapper
{
  //static ChromeDriver driver;
  static String baseUrl;
  static String port;
  static PhantomJSDriver driver;

  @BeforeClass
  public static void openBrowser()
  {

    /*DesiredCapabilities caps = new DesiredCapabilities();
    caps.setJavascriptEnabled(true);
    caps.setCapability(
      PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
      "phantomjs"
    );*/
    //driver = new PhantomJSDriver(caps);
    driver = new PhantomJSDriver();
    //driver = new ChromeDriver();


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //For local testing
    /*System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }*/
    //baseUrl = "http://localhost:" + port;


    // Testing the deployed version
    baseUrl = "https://arcane-tundra-47758.herokuapp.com/";
  }

  @AfterClass
  public static void closeBrowser()
  {
    driver.quit();
  }
}
