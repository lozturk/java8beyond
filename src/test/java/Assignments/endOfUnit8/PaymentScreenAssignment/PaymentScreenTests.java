package Assignments.endOfUnit8.PaymentScreenAssignment;


import com.google.common.util.concurrent.Uninterruptibles;
import lambda.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static Assignments.endOfUnit8.PaymentScreenAssignment.PaymentScreenActions.*;

public class PaymentScreenTests {

    private WebDriver driver;
    private PaymentScreenPage paymentScreenPage;


    @BeforeTest
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "testData")
    public void paymentScreenTests(Consumer<PaymentScreenPage> consumer){
        paymentScreenPage.goTo();  // for every test, refresh the page
        consumer.accept(paymentScreenPage);  // and do the test (consumer accepts paymentScreen Object)

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object [] testData(){
      return new Object[] {
//              PaymentScreenActions.validCC.andThen(PaymentScreenActions.buy).andThen(PaymentScreenActions.successfulPurchase)
              validCC.andThen(buy).andThen(successfulPurchase),
              freeCoupon.andThen(buy).andThen(successfulPurchase),
              discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
              invalidCC.andThen(buy).andThen(failedPurchase),
              invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
              buy.andThen(failedPurchase)



      };
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }



}
