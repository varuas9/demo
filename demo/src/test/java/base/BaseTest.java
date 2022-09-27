package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class BaseTest {

    public WebDriver driver;

    public void setup() {
        String browserValue = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"); //extracts the value of parameter passed from testng.xml
//      System.out.println("browser is: "+ value);
       this.driver = driverSetup();
//        multipleBrowserSetup(browserValue);
//        driver.manage().window().maximize();
        System.out.println("inside base test");
    }

    public WebDriver multipleBrowserSetup(String browserValue){
        try{
        if(browserValue.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserValue.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
            }
        }catch (NullPointerException e){
            System.out.println("exception");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

    public WebDriver driverSetup(){
        System.out.println("inside base test driverSetup");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
     }
}