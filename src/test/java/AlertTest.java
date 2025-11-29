import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");

    }

    @Test
    public void alertTestExample() throws InterruptedException {
        //alert simple dialog
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //alert confirm dialog
        driver.findElement(By.id("j_idt88:j_idt93")).click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        //alert prompt dialog
        driver.findElement(By.id("j_idt88:j_idt104")).click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert text is"+alertText);
        alert2.sendKeys("My name is binuri");
        alert2.accept();

    }
}
