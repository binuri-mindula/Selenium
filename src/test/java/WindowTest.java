import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");

    }

    @Test
    public void windowTest() throws InterruptedException {

        //click and confirm new window open

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent winodw" + oldWindow);
        WebElement openButton = driver.findElement(By.id("//*[@id='j_idt88:new']"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles =  driver.getWindowHandles();
        System.out.println("Handles size"+handles.size());

        //first method using foreach loop
        for(String handle : handles){
            System.out.println("Print new window handle"+handle);
            driver.switchTo().window(handle);
            System.out.println("Page title is  "+driver.getTitle());
        }

        driver.close();

        WebElement optionbutton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
       boolean openButtonResability = optionbutton1.isDisplayed();
        System.out.println("Button Visibility "+openButtonResability);
    }
}
