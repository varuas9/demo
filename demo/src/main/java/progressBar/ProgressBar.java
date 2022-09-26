package progressBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBar {

    private final String baseUrl="https://demoqa.com/progress-bar";

    ProgressBar.progressBarElements elements;

    public ProgressBar(WebDriver driver){
        elements = new ProgressBar.progressBarElements(driver);
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
