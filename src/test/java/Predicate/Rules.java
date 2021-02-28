package Predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static final Predicate<WebElement> HAS_S = e -> e.getText().toLowerCase().trim().contains("s");
    private static final Predicate<WebElement> ISBLANK = e -> e.getText().trim().length() == 0;

    public static List<Predicate<WebElement>> get(){
        List<Predicate<WebElement>> rulesOfPredicates = new ArrayList<>();
        rulesOfPredicates.add(HAS_S);
        rulesOfPredicates.add(ISBLANK);
        return rulesOfPredicates;
    }






}
