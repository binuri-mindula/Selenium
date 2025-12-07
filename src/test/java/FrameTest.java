import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class FrameTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");


    }

    @Test
    public void FrameTest(){
        //click me (inside frame) - want to switch to the frame first

        driver.switchTo().frame(0);

        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();
        String afterText = button1.getText();
        System.out.println(afterText);


        //click me (inside nested frame)
        driver.switchTo().defaultContent();  //first want to switch main page
        driver.switchTo().frame(2);
        //driver.switchTo().frame(0); //or by id
        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();
        String afterText2 = button3.getText();
        System.out.println(afterText2);

        // driver.switchTo().parentFrame();  //using this can switch to parent frame in nested
        //how many frames in this page

        driver.switchTo().defaultContent();
        List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
        int count = getIframeTagCount.size();
        System.out.println("Count of iframe tag is: " + count);  //only get 3 because main page can see its contain pages only

        for (WebElement iFrameElement : getIframeTagCount) {
            String frameSrcAttributeValue = iFrameElement.getAttribute("src");
            System.out.println("Frame src attribute value: " + frameSrcAttributeValue);

        }

    }

}
