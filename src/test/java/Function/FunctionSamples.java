package Function;

import Supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/*
Functions are used for transformation
Function<T,R> -> If you give something, it will convert & return another type
It comes with apply() method
Lambda chaining andThen(function), compose(function)
BiType -> BiFunction<T,U,R> ; T & U are 2 different input types and R is the return type
*/

public class FunctionSamples {

    private WebDriver webDriver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("firefox") String browser){
        webDriver = DriverFactory.getDriver(browser);
        webDriver.get("https://www.chrome.com");
     //   https://worldveterans.org/
    }

    @Test
    public void functionSampleA (){



    }


    @AfterClass
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }



}
