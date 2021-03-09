package Streams.assignments.checkboxSelection;

import lambda.supplier.DriverFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CheckboxSelectionTest {

    private WebDriver driver;
    public AssignmentPage assignmentPage;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        final String URL = "https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html";
        this.driver.get(URL);
        assignmentPage = new AssignmentPage(this.driver);
    }

    @Test(priority = 1)
    public void checkboxTest(){
        List <WebElement> checkboxes = assignmentPage.allCheckBoxes;
        Consumer<WebElement> clickOnCheckbox = WebElement::click;
        checkboxes.forEach(clickOnCheckbox);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    }

    @DataProvider(name="gender")
    public Object[] genders () {
         return new Object[] {
                 "Male",
                 "Female"
         };
    }

    @Test(priority = 2, dataProvider = "gender")
    public void selectCheckboxByGender(String gender){
        assignmentPage.selectRowsByGender(gender);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }



}
