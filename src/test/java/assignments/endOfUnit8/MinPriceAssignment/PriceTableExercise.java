package assignments.endOfUnit8.MinPriceAssignment;



import com.google.common.util.concurrent.Uninterruptibles;
import lambda.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriceTableExercise {

    WebDriver driver;
    PricePage pricePage;

    @BeforeMethod
    public void setDriver(@Optional("chrome") String browser){
        driver = DriverFactory.getDriver(browser);
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
        pricePage = new PricePage(driver);

    }

    @Test
    public void minPriceTest(){
        System.out.println(pricePage.getMinimumPrice());
        pricePage.clickOnMinPrice();
        pricePage.verifyStatusPass();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);


    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }


}
