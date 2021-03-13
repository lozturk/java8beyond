package Assignments.endOfUnit8.PaymentScreenAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreenPage {

    private final WebDriver driver;

    PaymentScreenPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy (id = "coupon")
    public WebElement enterCoupon;

    @FindBy (id = "couponbtn")
    public WebElement applyButton;

    @FindBy (id = "cc")
    public WebElement enterPAN;

    @FindBy (id = "year")
    public WebElement enterYear;

    @FindBy (id = "cvv")
    public WebElement enterCVV;

    @FindBy (id = "price")
    public WebElement totalPrice;

    @FindBy (id = "buy")
    public WebElement buyNowButton;

    @FindBy (id = "status")
    public WebElement statusText;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void applyPromoCode(String promoCode){
        this.enterCoupon.sendKeys(promoCode);
        this.applyButton.click();
    }

    public void buyProduct(){
        this.buyNowButton.click();
    }

    public String getStatus(){
        return this.statusText.getText().trim();
    }

    public void enterCC(String cc, String year, String cvv){
        this.enterPAN.sendKeys(cc);
        this.enterYear.sendKeys(year);
        this.enterCVV.sendKeys(cvv);
    }











}
