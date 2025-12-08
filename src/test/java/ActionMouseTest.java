import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ActionMouseTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }

    @Test
    public void mouseTest() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");
        System.out.println("Move to element operation");

        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(2000);
//
//        action.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(2000);
//
//        action.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
//        Thread.sleep(2000);

        //using method chaining
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
              .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
              .moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        //drag and drop operation
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        action.clickAndHold(from).moveToElement(to).release(to).perform();   // 1st way



    }

}
