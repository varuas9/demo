package elements;

import base.baseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.seleniumUtils;

public class textBoxTest extends baseTest {

    textBox obj;
    textBox.textBoxElements elements;

    @BeforeClass
    public void setup(){
        super.setup();
        obj = new textBox(driver);
        elements = new textBox.textBoxElements(driver);
        obj.goToTextBox(driver);
    }

    @Test
    public void test1(){
        //obj.enterInfoAndSubmit(driver);
        elements.fullName.sendKeys("myname");
        elements.email.sendKeys("email@gmail.com");
        elements.currentAddress.sendKeys("current address");
        elements.permanentAddress.sendKeys("permanent address");

//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("arguments[0].scrollIntoView(true);",elements.submit);
        seleniumUtils.scrollToElement(driver,elements.submit);
        elements.submit.click();

        Assert.assertTrue(elements.displayedName.getText().contains("myname"));
        Assert.assertEquals(elements.displayedName.getText(),"Name:myname");

        Assert.assertTrue(elements.displayedEmail.getText().contentEquals("Email:email@gmail.com"));
        Assert.assertTrue(elements.displayedCurAddress.getText().contentEquals("Current Address :current address"));
        Assert.assertTrue(elements.displayedPermAddress.getText().contentEquals("Permananet Address :permanent address"));
    }
}
