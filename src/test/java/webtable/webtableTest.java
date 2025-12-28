package webtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class webtableTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

    }

    @Test
    public void webTableTest() throws InterruptedException {
        //how many rows in the table
        int rowcount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row size is "+ rowcount);

        //how many columns in the table
        int columncount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column size is "+ columncount);

        //retrieve specific row column data
        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Value is "+ value);

        //retrieve all table data

        for(int i=1; i<=rowcount; i++){
            for (int j=1; j<=columncount-1; j++){
                String xpath = "//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]";
                String eachValue = driver.findElement(By.xpath(xpath)).getText();
                System.out.println("Value "+i + j +"-->"+ eachValue);
            }
            System.out.println();
        }


        //select all checkboxes
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//li"));
        for(int i=0; i<pageCount; i++){
            pages.get(i).click();
            Thread.sleep(1000);
            for (int k=1 ; k<=rowcount; k++){
                boolean attribute =driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+k+"]/td[4]/input")).isSelected();
                if (!attribute){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+k+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }
    }

}
