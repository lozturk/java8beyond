package streams.assignments.checkboxSelection;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class AssignmentPage {

    private WebDriver driver;

    AssignmentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(tagName = "input")
    public List<WebElement> allCheckBoxes;

    @FindBy(tagName = "tr")
    public List<WebElement> rows;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
    }

    public void selectRowsByGender(String gender) {
        rows.stream()
                .skip(1)
                .map(row->row.findElements(By.tagName("td")))  // tdList
                .filter(tdList->tdList.get(1).getText().trim().equalsIgnoreCase(gender))    //check ifGender
                .map(tdList->tdList.get(3)) // td element which containing checkbox
                .map(td->td.findElement(By.tagName("input")))  // input element
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.navigate().refresh();
    }


    public void selectRowsBySearchCriteria(Predicate<List<WebElement>> searchCriteria) {
        rows.stream()
                .skip(1)
                .map(row->row.findElements(By.tagName("td")))  // tdList
                .filter(tdList->tdList.size() == 4)
                .filter(searchCriteria)    //check Gender if isMale/isFemale
                .map(tdList->tdList.get(3)) // td element which containing checkbox
                .map(td->td.findElement(By.tagName("input")))  // input element
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        driver.navigate().refresh();
    }




}
