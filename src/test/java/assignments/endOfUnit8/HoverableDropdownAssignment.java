package assignments.endOfUnit8;

import com.google.common.util.concurrent.Uninterruptibles;
import lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HoverableDropdownAssignment {

    private WebDriver driver;
    private Actions actions;


    @BeforeTest
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html#");
        this.actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void dropDownTest(String path){
        String [] topMenu = path.split("=>");

        Arrays.stream(topMenu)
                .map(s -> s.trim())
                .map(s -> By.linkText(s))
                .map(by -> driver.findElement(by))
                .map(element -> actions.moveToElement(element))
                .forEach(act -> act.perform());

        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
    }

    @DataProvider(name = "linkProvider")
    public Object [] testLinks() {
        return new Object[] {
                "Dropdown => Dropdown Link 2",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2"
        };

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }




}
