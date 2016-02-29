package com.rickhanberryfinal.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
        // open | /#/ | 
        driver.get(baseUrl + "/#/");
        // click | css=button.btn.btn-primary | 
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        // click | //button[2] | 
        driver.findElement(By.xpath("//button[2]")).click();
        // click | //button[2] | 
        driver.findElement(By.xpath("//button[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_unitOfMeasure | splash
        driver.findElement(By.id("field_unitOfMeasure")).clear();
        driver.findElement(By.id("field_unitOfMeasure")).sendKeys("splash");
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | xpath=(//button[@type='submit'])[9] | 
        driver.findElement(By.xpath("(//button[@type='submit'])[9]")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | //button[2] | 
        driver.findElement(By.xpath("//button[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_ingredient | salt
        driver.findElement(By.id("field_ingredient")).clear();
        driver.findElement(By.id("field_ingredient")).sendKeys("salt");
        // type | id=field_ingredientCost | .01
        driver.findElement(By.id("field_ingredientCost")).clear();
        driver.findElement(By.id("field_ingredientCost")).sendKeys(".01");
        // select | id=field_unitOfMeasure | label=Dash
        new Select(driver.findElement(By.id("field_unitOfMeasure"))).selectByVisibleText("Dash");
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[2]/ul/li/a/span[2] | 
        driver.findElement(By.xpath("//li[2]/ul/li/a/span[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_drinkRecipe | saltcoffee
        driver.findElement(By.id("field_drinkRecipe")).clear();
        driver.findElement(By.id("field_drinkRecipe")).sendKeys("saltcoffee");
        // addSelection | id=field_ingredients | label=Espresso
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=field_ingredients | label=Espresso]]
        // addSelection | id=field_ingredients | label=salt
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=field_ingredients | label=salt]]
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | //button[@type='submit'] | 
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[5]/a/span[2] | 
        driver.findElement(By.xpath("//li[5]/a/span[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_bakeryCategory | cronut
        driver.findElement(By.id("field_bakeryCategory")).clear();
        driver.findElement(By.id("field_bakeryCategory")).sendKeys("cronut");
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | link=Main Menu | 
        driver.findElement(By.linkText("Main Menu")).click();
        // click | //li[6]/a/span[2] | 
        driver.findElement(By.xpath("//li[6]/a/span[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_vendor | joes cronut
        driver.findElement(By.id("field_vendor")).clear();
        driver.findElement(By.id("field_vendor")).sendKeys("joes cronut");
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[7]/a/span[2] | 
        driver.findElement(By.xpath("//li[7]/a/span[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_allergen | fish
        driver.findElement(By.id("field_allergen")).clear();
        driver.findElement(By.id("field_allergen")).sendKeys("fish");
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[4]/a/span[2] | 
        driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
        // click | //button | 
        driver.findElement(By.xpath("//button")).click();
        // type | id=field_bakedGood | fish cronut
        driver.findElement(By.id("field_bakedGood")).clear();
        driver.findElement(By.id("field_bakedGood")).sendKeys("fish cronut");
        // type | id=field_bakedGoodCost | 44.01
        driver.findElement(By.id("field_bakedGoodCost")).clear();
        driver.findElement(By.id("field_bakedGoodCost")).sendKeys("44.01");
        // select | id=field_bakeryCategory | label=cronut
        new Select(driver.findElement(By.id("field_bakeryCategory"))).selectByVisibleText("cronut");
        // select | id=field_vendor | label=joes cronut
        new Select(driver.findElement(By.id("field_vendor"))).selectByVisibleText("joes cronut");
        // addSelection | id=field_allergens | label=fish
        // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=field_allergens | label=fish]]
        // click | css=div.modal-footer > button.btn.btn-primary | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        // click | xpath=(//button[@type='submit'])[5] | 
        driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | //button[4] | 
        driver.findElement(By.xpath("//button[4]")).click();
        // click | xpath=(//button[@type='submit'])[8] | 
        driver.findElement(By.xpath("(//button[@type='submit'])[8]")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[6]/a/span[2] | 
        driver.findElement(By.xpath("//li[6]/a/span[2]")).click();
        // click | xpath=(//button[@type='submit'])[6] | 
        driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[5]/a/span[2] | 
        driver.findElement(By.xpath("//li[5]/a/span[2]")).click();
        // click | xpath=(//button[@type='submit'])[7] | 
        driver.findElement(By.xpath("(//button[@type='submit'])[7]")).click();
        // click | css=div.modal-footer > button.btn.btn-danger | 
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-danger")).click();
        // click | css=span > span.hidden-sm | 
        driver.findElement(By.cssSelector("span > span.hidden-sm")).click();
        // click | //li[4]/a/span[2] | 
        driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
        // click | css=span.glyphicon.glyphicon-home | 
        driver.findElement(By.cssSelector("span.glyphicon.glyphicon-home")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
