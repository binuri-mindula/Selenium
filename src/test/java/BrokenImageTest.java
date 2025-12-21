import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImageTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {
        ChromeOptions options = new ChromeOptions();
        File file = new File("C:\\Users\\Asus\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
        options.addExtensions(file);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    @Test
    public void brokenTest() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
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
