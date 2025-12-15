import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/broken_images");
    }
    @Test
    public void brokenTest() {
        List<WebElement> images =  driver.findElements(By.xpath("//div[@class='example']/img"));
        for(WebElement image :images){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image is broken");
            }else{
                System.out.println("Image is not broken");
            }
        }

    }
}
