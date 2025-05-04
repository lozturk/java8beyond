package lambda.supplier;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> CHROMESUPPLIER = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> CHROMEHEADLESS = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    };

    private static final Supplier<WebDriver> FIREFOXSUPPLIER = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    private static final Supplier<WebDriver> EDGESUPPLIER = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    private static final Map<String,Supplier<WebDriver>> DRIVERPOOL = new HashMap<>();

    static {
        DRIVERPOOL.put("chrome",CHROMESUPPLIER);
        DRIVERPOOL.put("chrome-headless",CHROMEHEADLESS);
        DRIVERPOOL.put("firefox",FIREFOXSUPPLIER);
        DRIVERPOOL.put("edge",EDGESUPPLIER);
    }


    // below is another notation of the map (IMMUTABLE MAP)
    private static final Map<String, Supplier<WebDriver>> DRIVER_POOL = Map.of(
            "chrome",CHROMESUPPLIER,
            "firefox",FIREFOXSUPPLIER,
            "chrome-headless",CHROMEHEADLESS,
            "edge",EDGESUPPLIER
    );

    public static WebDriver getDriver(String browser){
        return DRIVERPOOL.get(browser).get();
    }









}
