import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxExample(){

        //type name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Binuri");

        //country
        WebElement appendText =driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //verify
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is enabled: " + enabled);

        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        WebElement retrieveText =driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retrieveText.getAttribute("value");
        System.out.println(value);

        WebElement emailText = driver.findElement(By.id("j_idt88:j_idt99"));
        emailText.sendKeys("India@gmail.com" + Keys.TAB + "Confirm control moved to next element");
    }
}
