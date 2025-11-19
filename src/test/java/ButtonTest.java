import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){

        //click
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual is same as expected");
        }else{
            System.out.println("Actual not same as expected");
        }

        driver.navigate().back();

        //position
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("x: " + x + " y: " + y);

        //find color
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt94"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Color: " + color);

        //height and width
        WebElement size = driver.findElement(By.id("j_idt88:j_idt94"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height: " + height + " Width: " + width);


    }
}
