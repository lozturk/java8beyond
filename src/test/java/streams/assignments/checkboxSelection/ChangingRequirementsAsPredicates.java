package streams.assignments.checkboxSelection;

import lambda.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;
import java.util.function.Predicate;

public class ChangingRequirementsAsPredicates {

    private WebDriver driver;
    public AssignmentPage assignmentPage;

    Predicate<List<WebElement>> isMale = tdList->tdList.get(1).getText().trim().equalsIgnoreCase("male");
    Predicate<List<WebElement>> isFemale = tdList->tdList.get(1).getText().trim().equalsIgnoreCase("female");
    Predicate<List<WebElement>> fromUSA = tdList->tdList.get(2).getText().trim().equalsIgnoreCase("USA");
    Predicate<List<WebElement>> fromUK = tdList->tdList.get(2).getText().trim().equalsIgnoreCase("UK");
    Predicate<List<WebElement>> fromAU = tdList->tdList.get(2).getText().trim().equalsIgnoreCase("AU");

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        assignmentPage = new AssignmentPage(this.driver);
    }


    @DataProvider(name="gender")
    public Object[] genders () {
        Predicate<List<WebElement>> allGender = isMale.or(isFemale);
        return new Object[] {
                isMale,
                isFemale,
                allGender,
                isMale.and(fromUSA),
                isFemale.and(fromUK),
                fromUK.negate(),
                fromUSA.negate(),
                fromAU.negate().and(isFemale)

        };
    }

    @Test(dataProvider = "gender")
    public void selectCheckboxByCriteria(Predicate<List<WebElement>> searchCriteria){
        assignmentPage.goTo();
        assignmentPage.selectRowsBySearchCriteria(searchCriteria);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }






}
