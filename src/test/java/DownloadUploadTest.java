import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/file.xhtml");
    }

    @Test
    public void downloadTest() throws InterruptedException {

        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        //check whether this file downloaded or not (Using java)
        File file = new File("C:\\Users\\Asus\\Downloads");
        File[] totalFiles = file.listFiles();
        for (File findFile : totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png"));
            System.out.println("File is downloaded");
             break;
        }

    }

    @Test
    public void uploadTest() throws AWTException, InterruptedException {


        //1st way - using robot class
        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows controls begins here
        String data = "C:\\Users\\Asus\\Downloads\\TestLeaf Logo.png";
        StringSelection selection = new StringSelection(data);

        //copying the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        //2ND way  -  using send keys(Applicable only element type is file) (input type = file )

        WebElement uploadSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadSendKeys.sendKeys(data);


    }

}
