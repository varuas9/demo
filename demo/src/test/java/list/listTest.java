package list;

import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import utils.waitUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listTest extends baseTest {

    List expectedValues = new ArrayList();
    Actions actions;
    private final String baseUrl = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";


    @BeforeClass
    public void setup(){
        super.setup();
        driver.navigate().to(baseUrl);
        expectedValues = Arrays.asList("Day selected :- Sunday", "Day selected :- Monday", "Day selected :- Tuesday", "Day selected :- Wednesday",
                "Day selected :- Thursday", "Day selected :- Friday", "Day selected :- Saturday");
        actions = new Actions(driver);
    }


    @Test //loop through xpaths and select all options from dropdown. Store selected values in a list and assert.
    public void dropDownTest1() {
        System.out.println("inside test dropDownTest1");
        List<String> days = new ArrayList<>();
        WebElement dropDown = driver.findElement(By.id("select-demo"));
        WebElement displayedValue = driver.findElement(By.xpath("//p[@class='selected-value']"));
        dropDown.click();
        for (int i=2;i<=8;i++){
            driver.findElement(By.xpath("//*[@id=\"select-demo\"]/option["+i+"]")).click();
//            dropDown.click();
            days.add(displayedValue.getText());
            System.out.println(displayedValue.getText());
        }

        Assert.assertTrue(expectedValues.equals(days));
    }


    @Test //use select.selectByIndex to loop through all the options of the dropdown and click them
    public void dropDownTest2() {
        System.out.println("inside test dropDownTest2");
        WebElement dropDown = driver.findElement(By.id("select-demo"));
        WebElement displayedValue = driver.findElement(By.xpath("//p[@class='selected-value']"));
        dropDown.click();
        Select select = new Select(dropDown);
        for(int i = 1; i <=7; i++){
            select.selectByIndex(i);
            System.out.println(displayedValue.getText());
        }
    }

    @Test //use a for each loop along with select.getOptions() to loop through options and click them
    public void dropDownTest3() {
        System.out.println("inside test dropDownTest3");
        WebElement dropDown = driver.findElement(By.id("select-demo"));
        WebElement displayedValue = driver.findElement(By.xpath("//p[@class='selected-value']"));
        dropDown.click();
        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();

        for (WebElement webElement : options) {
            webElement.click();
            System.out.println(displayedValue.getText());
        }
    }

    @Test //use actions to press shift and select all the options
    public void multiSelectListTest1(){
        WebElement multiSelectList = driver.findElement(By.id("multi-select"));
        Select select = new Select(multiSelectList);
        System.out.println("inside multiSelectListTest2");
        for(int i = 1; i <=8; i++){
            actions.keyDown(Keys.SHIFT);
            driver.findElement(By.xpath("//*[@id=\"multi-select\"]/option["+i+"]")).click();
            actions.release();
        }
        waitUtils.waitForSeconds(3);
        select.deselectAll();
    }

    @Test //use a for each loop along with select.getOptions() to loop through options and click them
    public void multiSelectListTest2(){
        WebElement multiSelectList = driver.findElement(By.id("multi-select"));
        Select select = new Select(multiSelectList);
        System.out.println("inside multiSelectListTest3");
        List<WebElement> options = select.getOptions();;
        for(WebElement element : options){
            element.click();
        }
        waitUtils.waitForSeconds(3);
        select.deselectAll();
    }
}



