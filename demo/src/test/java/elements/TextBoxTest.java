package elements;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.SeleniumUtils;

public class TextBoxTest extends BaseTest {

    TextBox obj;
    TextBox.textBoxElements elements;

    @BeforeClass
    public void setup(){
        super.setup();
        obj = new TextBox(driver);
        elements = new TextBox.textBoxElements(driver);
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
        SeleniumUtils.scrollToElement(driver,elements.submit);
        elements.submit.click();

        Assert.assertTrue(elements.displayedName.getText().contains("myname"));
        Assert.assertEquals(elements.displayedName.getText(),"Name:myname");

        Assert.assertTrue(elements.displayedEmail.getText().contentEquals("Email:email@gmail.com"));
        Assert.assertTrue(elements.displayedCurAddress.getText().contentEquals("Current Address :current address"));
        Assert.assertTrue(elements.displayedPermAddress.getText().contentEquals("Permananet Address :permanent address"));
    }
}
