package progressBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class progressBar {

    private final String baseUrl="https://demoqa.com/progress-bar";

    progressBar.progressBarElements elements;

    public progressBar(WebDriver driver){
        elements = new progressBar.progressBarElements(driver);
    }

    public void goToprogressBar(WebDriver driver){
        driver.get(baseUrl);
    }


    public static class progressBarElements {
        public progressBarElements(WebDriver driver){
            PageFactory.initElements(driver,this);
        }

        @FindBy(id = "startStopButton")
        public WebElement button =null;

        @FindBy(className = "progress")
//        @FindBy(className = "progress-bar")
        public WebElement progressPercent =null;

    }
}
