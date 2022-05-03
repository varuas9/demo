package elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.seleniumUtils;

public class textBox {

    private final String baseUrl = "https://demoqa.com/text-box";
    textBoxElements elements;


    public textBox(WebDriver driver) {
        elements = new textBoxElements(driver);
    }

    public void goToTextBox(WebDriver driver) {
        driver.get(baseUrl);
    }

    public void enterInfoAndSubmit(WebDriver driver) {
        elements.fullName.sendKeys("myname");
        elements.email.sendKeys("email@gmail.com");
        elements.currentAddress.sendKeys("current address");
        elements.permanentAddress.sendKeys("permanent address");

        seleniumUtils.scrollToElement(driver, elements.submit);
        elements.submit.click();
    }


    public static class textBoxElements {
        public textBoxElements(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "userName")
        public WebElement fullName = null;

        @FindBy(id = "userEmail")
        public WebElement email = null;

        @FindBy(id = "currentAddress")
        public WebElement currentAddress = null;

        @FindBy(id = "permanentAddress")
        public WebElement permanentAddress = null;

        @FindBy(id = "submit")
        public WebElement submit = null;

        @FindBy(id = "name")
        public WebElement displayedName = null;

        @FindBy(id = "email")
        public WebElement displayedEmail = null;

        @FindBy(xpath = "//p[@id='currentAddress']")
        public WebElement displayedCurAddress = null;

        @FindBy(xpath = "//p[@id='permanentAddress']")
        public WebElement displayedPermAddress = null;
    }
}