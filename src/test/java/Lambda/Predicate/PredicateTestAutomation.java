package Lambda.Predicate;

import Lambda.Supplier.DriverFactory;
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
    public void initDriver(@Optional("chrome-headless")String browser){
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

        System.out.println("--------------------------------------------------");

        // exercise : just print the links which does NOT contains "S".

        Predicate<WebElement> hasS = webElement -> webElement.getText().toLowerCase().contains("s");

        elements.removeIf(hasS);

        elements.forEach(webElement -> System.out.println(
                "Elements not contain s :"  + webElement.getText().trim().toUpperCase()
        ));
    }

    @Test
    public void predicatesInRulesClass(){
        driver.get("https://www.google.com");
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));

        webElementList.forEach(e -> System.out.println("Before remove :: " + e.getText().trim()));
        System.out.println("Count before remove :: " + webElementList.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        // removing webElements which has blank
        webElementList.removeIf(Rules.get().get(1));

        // removing webElements which contains "S"
        webElementList.removeIf(Rules.get().get(0));

        webElementList.forEach(e -> System.out.println("After remove :: " + e.getText().trim()));
        System.out.println("Count after remove :: " + webElementList.size());

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("We will handle all the rules in one line");

        // Rules.get() -> it will return us List of predicates of webElements
        Rules.get().forEach(rule -> webElementList.removeIf(rule));  // -> Lambda expression
        Rules.get().forEach(webElementList::removeIf);  // -> Method reference expression

    }

    @Test
    public void listOfPredicates(){
        driver.get("https://www.google.com");
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));

        webElementList.forEach(e -> System.out.println("Before remove :: " + e.getText().trim()));
        System.out.println("Count before remove :: " + webElementList.size());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        // removing webElements which has blank & contains S
        // Rules.get() -> it will return us List of predicates of webElements
//        Rules.get().forEach(rule -> webElementList.removeIf(rule));  // -> Lambda expression
        Rules.get().forEach(webElementList::removeIf);  // -> Method reference expression

        webElementList.forEach(e -> System.out.println("After remove :: " + e.getText().trim()));
        System.out.println("Count after remove :: " + webElementList.size());

    }

    @AfterTest
    public void quit(){
        driver.quit();
    }



}
