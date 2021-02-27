package Predicate;

import Supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTestAutomation {

    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void initDriver(@Optional("chrome")String browser){
        driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void predicateTest(){
        driver.get("https://www.google.com/");
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        // predicate sample
        Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;

        System.out.println(
                "Before remove :: " + elements.size()
        );

        // consumer sample
        Consumer<WebElement> getText = webElement -> System.out.println( webElement.getText().trim() );

        // consumer sample inside forEach
        elements.forEach(webElement -> System.out.println( webElement.getText().trim() )   );

        // removeIf is a method used with predicate
        elements.removeIf(isBlank);

        System.out.println(
                "After remove :: " + elements.size()
        );

        elements.forEach(getText);

    }

    @AfterTest
    public void quit(){
        driver.quit();
    }



}
