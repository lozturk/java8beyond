package assignments.endOfUnit8.MinPriceAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PricePage {

    WebDriver driver;

    PricePage(WebDriver driver){
        this.driver = driver;
//        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id='prods']/tbody/tr")
    private List<WebElement> allRows;

    @FindBy(css = "table#prods tr")
    private List<WebElement> rows;

    @FindBy(xpath = "//*[@id='prods']/tbody/tr/td[3]")
    public List<WebElement> allPrices;

    @FindBy(id = "status")
    public WebElement status;

    @FindBy(id = "result")
    public WebElement verifyButton;

    public Integer getMinimumPrice(){


        int minPrice = allPrices.stream()
                .map(e->e.getText().trim())
                .mapToInt(s -> Integer.parseInt(s))
                .min()
                .getAsInt();

        return minPrice;
    }

    public void clickOnMinPrice(){
        allPrices.forEach(element -> {
           if ( element.getText().trim().equalsIgnoreCase(String.valueOf(getMinimumPrice()))  ) {
               element.findElement(By.xpath("../td/input")).click();
           }
        });
    }

    public void verifyStatusPass(){
        verifyButton.click();
        Assert.assertTrue(status.getText().trim().equalsIgnoreCase("PASS"));

    }



}
