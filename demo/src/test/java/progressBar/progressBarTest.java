package progressBar;

import base.baseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.waitUtils;

public class progressBarTest extends baseTest {

    progressBar obj;
    progressBar.progressBarElements elements;

    @BeforeClass
    public void setup(){
        super.setup();
        obj = new progressBar(driver);
        elements = new progressBar.progressBarElements(driver);
        obj.goToprogressBar(driver);
    }

    @Test
    public void test(){
        elements.button.click();
        waitUtils.waitForSeconds(5);
        Assert.assertFalse(elements.progressPercent.getText().contentEquals("100%"));
        System.out.println("percentage after 5 seconds is : " + elements.progressPercent.getText());
        waitUtils.waitForSeconds(15);
        System.out.println("percentage after 15 seconds is : " + elements.progressPercent.getText());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-valuenow='100']")).isDisplayed());
        waitUtils.waitForElement(driver,driver.findElement(By.xpath("//div[@aria-valuenow='100']")),15);
        Assert.assertTrue(elements.progressPercent.getText().contentEquals("100%"));
    }
}