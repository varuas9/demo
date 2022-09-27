import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class ActionTests extends BaseTest {

    Actions actions;

    @BeforeClass
    public void setup(){
        super.setup();
        actions = new Actions(driver);
    }

    @Test (priority = 2)
    public void dragDropTest(){
        driver.get("https://demoqa.com/droppable/");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source,destination).perform();
    }

    @Test (priority = 1)
    public void mouseHover(){
        driver.get("https://phptravels.com/demo/");
        WebElement dropDown = driver.findElement(By.xpath("//span[text()='Features']"));
        WebElement mainFeatures = driver.findElement(By.xpath("//a[contains(text(),'Main Features')]"));
        WebElement flights = driver.findElement(By.xpath("//a[contains(text(),'Flights Module')]"));
        WebElement cars = driver.findElement(By.xpath("//a[contains(text(),'Cars Module')]"));

        actions.moveToElement(dropDown).perform();
        WaitUtils.waitForSeconds(2);
        actions.moveToElement(mainFeatures).perform();
        WaitUtils.waitForSeconds(2);
        actions.moveToElement(flights).perform();
        WaitUtils.waitForSeconds(2);
        actions.moveToElement(cars).perform();
    }

    /*@Test
    public void copyPaste(){
        driver.get("https://demoqa.com/text-box");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        currentAddress.sendKeys("address");

        //select
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        WaitUtils.waitForSeconds(2);

        //copy
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.perform();

        //TAB
        WaitUtils.waitForSeconds(2);
        actions.sendKeys(Keys.TAB);
        actions.perform();

        WaitUtils.waitForSeconds(2);

        //paste
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }*/

}
