import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
//        Dimension newSize = new Dimension(800, 600);
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node061r5l9t35nde1lbv4llbc2cev8896036.node0");
    }

    @Test
    public void leafGroundDropdownTest() throws InterruptedException {

        //select values in basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class=\'ui-selectonemenu\']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Puppeteer");

    }
}
