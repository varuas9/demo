import base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.seleniumUtils;
import utils.waitUtils;

import java.util.ArrayList;

public class remainingTests extends baseTest {

    @BeforeClass
    public void setup() {
        super.setup();
    }

    @Test
    public void newWindow(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switch to new tab
        driver.navigate().refresh();
        driver.close();

        driver.switchTo().window(tabs.get(0)); //switch back to parent tab
        driver.findElement(By.id("windowButton")).click();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        waitUtils.waitForSeconds(2);
        driver.close();
    }


    @Test
    public void alert(){
        driver.get("https://demoqa.com/alerts");

//        driver.findElement(By.id("confirmButton")).click();
//        waitUtils.waitForSeconds(2);
//        driver.switchTo().alert().accept();
//        //driver.switchTo().alert().dismiss();

        seleniumUtils.scrollToElement(driver,driver.findElement(By.id("promtButton")));
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("test123");
        driver.switchTo().alert().accept();
    }


}
