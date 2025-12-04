import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);

    }

    @Test
    public void windowTest() throws InterruptedException {

        //click and confirm new window open

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent winodw" + oldWindow);
        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles =  driver.getWindowHandles();
        System.out.println("Handles size"+handles.size());

        //first method using foreach loop
        for(String newWindow : handles){
            System.out.println("Print new window handle"+ newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is  "+driver.getTitle());
        }

        driver.close();
        driver.switchTo().window(oldWindow);

        WebElement optionbutton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
       boolean openButtonResability = optionbutton1.isDisplayed();
        System.out.println("Button Visibility "+openButtonResability);


        //second method - using list
//        List <String> list = new ArrayList<String>(handles); //converting set to list
//        if(list.size()>1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("Child tab title is  "+driver.getTitle());
//            driver.close();
//            driver.switchTo().window(oldWindow);
//        }
//
//        WebElement optionbutton2 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
//        boolean openButtonResability2 = optionbutton2.isDisplayed();
//        System.out.println("Button Visibility "+openButtonResability2);


        //find the number of open tabs
        WebElement multiwindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
        multiwindowButton.click();
        Thread.sleep(3000);

        Set<String> multiwindows = driver.getWindowHandles();
        int windowsSize = multiwindows.size();
        System.out.println("No of windows" + windowsSize);

        //close all windows except primary
        WebElement closeButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']"));
        closeButton.click();
        Thread.sleep(3000);
        Set<String> newWindowsHandles = driver.getWindowHandles();
        for(String allWindows : newWindowsHandles){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();

            }
        }
        driver.quit();

        //driver.close() -> close the single browser window driver which on focus
        //driver.quit() -> close all browser windows

    }
}
