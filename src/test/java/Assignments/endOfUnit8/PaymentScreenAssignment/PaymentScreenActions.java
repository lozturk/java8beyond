package Assignments.endOfUnit8.PaymentScreenAssignment;

import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {

    public static final Consumer<PaymentScreenPage> freeCoupon = (paymentScreenPage) -> paymentScreenPage.applyPromoCode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountedCoupon = (p)->p.applyPromoCode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> validCC = (p)->p.enterCC("4111111111111111","2023","123");
    public static final Consumer<PaymentScreenPage> invalidCC = (p)->p.enterCC("4111111111111112","2023","123");
    public static final Consumer<PaymentScreenPage> buy = PaymentScreenPage::buyProduct;

    // validations
    public static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(),"PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase = (p)-> Assert.assertEquals(p.getStatus(),"FAIL");




}
