import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class LocatorTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        super.setup();

        //by name
//        driver.get("https://www.google.com/");
//        driver.findElement(By.name("q")).sendKeys("selenium");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//
//        //by xpath
//        Thread.sleep(3000);
//
//        driver.navigate().back();
//        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium webdriver");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //by tagname
//        driver.get("https://www.google.com/");
//        System.out.println(driver.findElement(By.tagName("img")).getAttribute("height"));

        //by id
//        driver.get("https://demoqa.com/text-box");
//        driver.findElement(By.id("userName")).sendKeys("located by id");
//
//        Thread.sleep(3000);
//        //by css selector
//        driver.findElement(By.cssSelector("#userName")).clear();
//        driver.findElement(By.cssSelector("#userName")).sendKeys("located by css selector");

        //by linktext
//        driver.get("https://demoqa.com/links");
//        driver.findElement(By.partialLinkText("Cre")).click();

        //by classname
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        WaitUtils.waitForElement(driver,driver.findElement(By.className("gNO89b")),5);
        driver.findElement(By.className("gNO89b")).click();
    }
}