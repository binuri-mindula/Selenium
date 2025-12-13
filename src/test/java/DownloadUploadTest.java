import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;

public class DownloadUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
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
    public void uploadTest() throws AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way - using robot class
        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows controls begins here
        String data = "C:\\Users\\Asus\\Downloads";
        StringSelection selection = new StringSelection("null");

        Toolkit.getDefaultToolkit().getSystemClipboard().getContents(selection, null);

        Robot robot = new Robot();


    }

}
