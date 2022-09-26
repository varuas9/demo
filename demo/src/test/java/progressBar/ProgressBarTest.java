package progressBar;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class ProgressBarTest extends BaseTest {

    ProgressBar obj;
    ProgressBar.progressBarElements elements;

    @BeforeClass
    public void setup(){
        super.setup();
        obj = new ProgressBar(driver);
        elements = new ProgressBar.progressBarElements(driver);
        obj.goToprogressBar(driver);
    }

    @Test
    public void test(){
        elements.button.click();
        WaitUtils.waitForSeconds(5);
        Assert.assertFalse(elements.progressPercent.getText().contentEquals("100%"));
        System.out.println("percentage after 5 seconds is : " + elements.progressPercent.getText());
        WaitUtils.waitForSeconds(15);
        System.out.println("percentage after 15 seconds is : " + elements.progressPercent.getText());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-valuenow='100']")).isDisplayed());
        WaitUtils.waitForElement(driver,driver.findElement(By.xpath("//div[@aria-valuenow='100']")),15);
        Assert.assertTrue(elements.progressPercent.getText().contentEquals("100%"));
    }
}