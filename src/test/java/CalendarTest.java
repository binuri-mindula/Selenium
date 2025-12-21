import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class CalendarTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");

    }

    @Test
    public void calendarExample(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //method 1
        WebElement datepickerElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datepickerElement.sendKeys("02/12/2025");

        //method 2
        WebElement datepickerElement2 =driver.findElement(By.xpath("//input[@id='datepicker']"));
        driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));

    }
}
