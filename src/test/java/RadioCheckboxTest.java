import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void radioTest(){

        //find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeRadioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is "+chromeText);
        } else if (firefoxRadioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is "+firefoxText);
        }else if (safariRadioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is "+safariText);
        }else if (edgeRadioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is "+edgeText);
        }


        //another way for getting in simple code
        List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        int radioButtonCount = radioElements.size();
        System.out.println("radio button count is "+radioButtonCount);

        int index = -1;
        for(WebElement radioElement : radioElements){
            index++;
            if(radioElement.isSelected()){
                WebElement defaultSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2:"+index + "']"));
                String defaultSelectedRadioButtonText = defaultSelectedRadioButton.getText();
                System.out.println("Default selected radio button is "+defaultSelectedRadioButtonText);
                break;
            }
        }

        //Select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if(!isChecked){
            //myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }

        //another way
        String myAge = "1-20 Years";
        List<WebElement> ageGroups = driver.findElements(By.xpath("//div[@id='j_idt87:age']//label"));

        for(WebElement element: ageGroups){
            String ageGroupText = element.getText();
            if(ageGroupText.equals(myAge)){
                WebElement myRadioButtonOption = driver.findElement(By.xpath("//label[text()='" + ageGroupText + "']/parent::div//input"));
                if(!myRadioButtonOption.isSelected()){
                    element.click();
                }
                break;
            }
        }
    }

    @Test
    public void checkboxTest(){

        //select wanted checkbox and verifying their status
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for(WebElement element: checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for(int i =1; i<= checkBoxList.size(); i++){
            boolean selectedStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i + "]")).isSelected();
            System.out.println("Checkbox " + i + "Selected Status is " + selectedStatus);
        }
    }
}
