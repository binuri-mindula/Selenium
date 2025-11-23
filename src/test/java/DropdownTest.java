import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    }

    @Test
    public void leafGroundDropdownTest() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node061r5l9t35nde1lbv4llbc2cev8896036.node0");
        //select values in basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class=\'ui-selectonemenu\']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Puppeteer");

        //get no of dropdown options
        //generics
        List<WebElement> listOfOptions =select.getOptions();
        int size = listOfOptions.size();
        System.out.println("No of Elements : " + size);

        for(WebElement element: listOfOptions){
            System.out.println(element.getText());
        }

        //using send keys to select dropdown values
        dropdown.sendKeys("Puppeteer");

        //selected value in a bootstrap dropdown(no select html tag)
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listOfValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listOfValues){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("USA")) {
                element.click();
                break;
            }

        }
    }

        //google search - pick a value from suggestion

        @Test
        public void googleSearchDropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='lnnVSe']"));
            System.out.println("Google Search list" + googleSearchList.size());
            for (WebElement element : googleSearchList){
                String dropdownValue = element.getText();
                System.out.println(dropdownValue);


            }
        }

        //handle hidden auto suggestion dropdown and search using DOM debugger
    //Dev tools -> sources -> snippets -> new ->
    // setTimeout(function(){
    //       debugger;
    //     },3000);
    //->run




}
