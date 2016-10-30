package com.swagfish.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestTicTacToe extends SeleniumTestWrapper
{
  @Test
  public void titleMatches()
  {
    driver.get(baseUrl);
    assertEquals("SWAGFISH - TicTacToe", driver.getTitle());
  }
  @Test
  public void findElements()
  {
    driver.get(baseUrl);

    driver.findElement(By.name("button1"));
    driver.findElement(By.name("button2"));
    driver.findElement(By.name("button3"));
    driver.findElement(By.name("button4"));
    driver.findElement(By.name("button5"));
    driver.findElement(By.name("button9"));
    driver.findElement(By.name("button6"));
    driver.findElement(By.name("button7"));
    driver.findElement(By.name("button8"));
    driver.findElement(By.name("ng"));
  }
  @Test
  public void isDisplayed()
  {
    driver.get(baseUrl);

    driver.findElement(By.name("button1")).isDisplayed();
    driver.findElement(By.name("button2")).isDisplayed();
    driver.findElement(By.name("button3")).isDisplayed();
    driver.findElement(By.name("button4")).isDisplayed();
    driver.findElement(By.name("button5")).isDisplayed();
    driver.findElement(By.name("button6")).isDisplayed();
    driver.findElement(By.name("button7")).isDisplayed();
    driver.findElement(By.name("button8")).isDisplayed();
    driver.findElement(By.name("button9")).isDisplayed();
    driver.findElement(By.name("ng")).isDisplayed();
  }
  @Test
  public void clickTest()
  {
    driver.get(baseUrl);

    driver.findElement(By.name("button1")).click();
    driver.findElement(By.name("button2")).click();
    driver.findElement(By.name("button3")).click();
    driver.findElement(By.name("button4")).click();
    driver.findElement(By.name("button5")).click();
    driver.findElement(By.name("button6")).click();
    driver.findElement(By.name("button7")).click();
    driver.findElement(By.name("button8")).click();
    driver.findElement(By.name("button9")).click();
    driver.findElement(By.name("ng")).click();
  }
  @Test
  public void winTest()
  {
    driver.findElement(By.name("ng")).click();
    driver.findElement(By.name("button1")).click();
    driver.findElement(By.name("button2")).click();
    driver.findElement(By.name("button4")).click();
    driver.findElement(By.name("button5")).click();
    driver.findElement(By.name("button7")).click();
    driver.findElement(By.name("button8")).click();
    driver.findElement(By.name("button8")).getAttribute("X wins");
    driver.findElement(By.name("ng")).click();

  }

}
