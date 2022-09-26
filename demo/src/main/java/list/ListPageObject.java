package list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class ListPageObject {

    private final String baseUrl = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    listWebElements elements;
    List<String> days = new ArrayList<>();

    public ListPageObject(WebDriver driver){
        elements = new ListPageObject.listWebElements(driver);
    }

    public void goTolistPage(WebDriver driver) {
        driver.navigate().to(baseUrl);
    }

    public List<String> returnSelectedDays(WebDriver driver){
        elements.dropDown.click();
        for (int i=2;i<=8;i++){
            driver.findElement(By.xpath("//*[@id=\"select-demo\"]/option["+i+"]")).click();
            elements.dropDown.click();
            days.add(elements.displayedValue.getText());
            if(i==8){
                elements.selectListText.click();
            }
        }
        System.out.println(days);
        return days;
    }

    public static class listWebElements {
        public listWebElements(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "select-demo")
        public WebElement dropDown=null;

        @FindBy(xpath = "//div[text()='Select List Demo']")
        public WebElement selectListText =null;

        @FindBy(xpath = "//p[@class='selected-value']")
        public WebElement displayedValue =null;

        @FindBy(id = "multi-select")
        public WebElement multiSelectList = null;
    }
}
