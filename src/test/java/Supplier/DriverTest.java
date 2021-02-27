package Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void driverTest(){
        this.driver.get("https://worldveterans.org/");
    }

    @AfterTest
    public void tearDown(){
        this.driver.close();
    }


}
