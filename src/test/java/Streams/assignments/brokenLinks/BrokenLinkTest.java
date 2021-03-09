package Streams.assignments.brokenLinks;

import lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BrokenLinkTest {
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        String url = "https://the-internet.herokuapp.com/broken_images";
        this.driver.get(url);
    }

    @Test
    public void printAllLinks(){
        List<WebElement> allLinks = this.driver.findElements(By.xpath("//*[@src]"));
        allLinks.stream()
                .map(l->l.getAttribute("src"))
                .forEach(System.out::println);
    }

    @Test
    public void printResponseCodes(){
        List<WebElement> allLinks = this.driver.findElements(By.xpath("//*[@src]"));
        //        Predicate<String> isWorking = link->LinkUtil.getResponseCode(link) == 200;
        Predicate<String> isNotBroken = link->LinkUtil.getResponseCode(link) != 404;
        allLinks.stream()
                .map(l->l.getAttribute("src"))
                .map(link-> LinkUtil.getResponseCode(link))     // get response codes
                .forEach(System.out::println);
    }

    @Test
    public void printWorkingLinks(){
        List<WebElement> allLinks = this.driver.findElements(By.xpath("//*[@src]"));
        Predicate<String> isWorking = link->LinkUtil.getResponseCode(link) != 404;
        allLinks.stream()
                .map(l->l.getAttribute("src"))
                .filter(isWorking)
                .forEach(link-> System.out.println(link +" :: "+LinkUtil.getResponseCode(link) ));
    }

    @Test
    public void verifyIfBrokenLinkExistsWithAnyMatch(){
        List<WebElement> allLinks = this.driver.findElements(By.xpath("//*[@src]"));
        boolean isBrokenLinkExists = allLinks.stream()
                .map(l->l.getAttribute("src"))
                .map(LinkUtil::getResponseCode)
                .anyMatch(responseCode -> responseCode != 200);
        Assert.assertFalse(isBrokenLinkExists);
    }

    @Test
    public void verifyIfBrokenLinkExistsWithCollect(){
        List<WebElement> allLinks = this.driver.findElements(By.xpath("//*[@src]"));
        List<String> brokenLinksList = allLinks.stream()
                .map(l->l.getAttribute("src"))
                .filter(link -> LinkUtil.getResponseCode(link) != 200)
                .collect(Collectors.toList());
        Assert.assertEquals(brokenLinksList.size(), 0 ,brokenLinksList.toString());
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
