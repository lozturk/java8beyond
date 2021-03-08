package Streams.ParellelProcessing;

import Lambda.Supplier.DriverFactory;
import Streams.Assignments.BrokenLinks.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParallelProcess {
    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        String url = "https://www.google.com";
        this.driver.get(url);
    }

    @Test(priority = 1)
    public void durationOfTestWithoutParallel(){
        System.out.println("Before :: " + LocalDateTime.now());
        List<String> brokenLinksList = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(l->l.getAttribute("href"))
                .filter(link -> LinkUtil.getResponseCode(link) != 200)
                .collect(Collectors.toList());
        System.out.println(brokenLinksList);
        System.out.println("After :: " + LocalDateTime.now());
    }

    @Test(priority = 2)
    public void durationOfTestWithParallel(){
        System.out.println("Before :: " + LocalDateTime.now());
        List<String> brokenLinksList = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(l->l.getAttribute("href"))
                .filter(link -> LinkUtil.getResponseCode(link) != 200)
                .collect(Collectors.toList());
        System.out.println(brokenLinksList);
        System.out.println("After :: " + LocalDateTime.now());
    }
    // When we use parallel stream, we use findAny()
    // if we use sequential stream, then we can use findFirst()

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
