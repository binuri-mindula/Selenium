import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void keyBoardTest() throws InterruptedException {
        driver.get("https://duckduckgo.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Java");

        Actions action = new Actions(driver);

        //select the text
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(2000);

        action.keyDown(Keys.SHIFT).sendKeys("Capital").keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();

        //another way
//        action.keyUp(searchBox,Keys.SHIFT).perform();
    }

    @Test
    public void keyBoardTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");

        Thread.sleep(4000);
        List<WebElement> selectables = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectables.size();
        System.out.println("Li size is "+size);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(selectables.get(0))
                .click(selectables.get(2))
                .click(selectables.get(3))
                .click(selectables.get(2))
                .perform();
    }
}
