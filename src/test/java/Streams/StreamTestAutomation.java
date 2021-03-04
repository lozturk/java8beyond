package Streams;

import Lambda.Supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class StreamTestAutomation {

    private WebDriver driver;


    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome-headless") String browser){
        driver = DriverFactory.getDriver(browser);
        driver.get("https://www.google.com");
    }

    @Test
    public void streamTest(){
        List<WebElement> links = driver.findElements(By.tagName("a"));

        links.stream()
                .filter(e-> e.getText().trim().length() > 0)
                .filter(e-> !e.getText().toLowerCase().contains("s"))
                .map(e->e.getText().trim().toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------------------------------");

        links.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s-> s.length() > 5)
                .filter(s-> !s.contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
