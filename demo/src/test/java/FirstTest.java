import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

//public class firstTest {
public class FirstTest extends BaseTest {
    private final String baseUrl = "https://demoqa.com/";

    @Test
    public void testTitle(){
        super.setup();

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        String expectedTitle = "ToolsQA";
        String actualTitle = "";
        driver.navigate().to(baseUrl); //driver.get(baseUrl)
        actualTitle = driver.getTitle();
        Assert.assertTrue(expectedTitle.contentEquals(actualTitle));
        System.out.println("actual title is " + actualTitle);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        element.click();

        WebElement element2 = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(element2.isDisplayed());
    }
}