package Consumer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ConsumerExamples {

    List <String> allDrivers;

    @Test (priority = 1)
    public void consumerWithForEach(){

        allDrivers = new ArrayList<>();
        allDrivers.add("chrome");
        allDrivers.add("ff");
        allDrivers.add("safari");
        allDrivers.add("edge");
        allDrivers.add("ie");
        allDrivers.add("remote");
//        Consumer <String> displayDrivers = (d) -> System.out.println(d); // Lambda
        Consumer <String> displayDrivers = System.out::println;            // Method reference
        allDrivers.forEach(displayDrivers);

        // we can pass the lambda inside the forEach as well
        allDrivers.forEach(d-> System.out.println(d));  // consumer inside forEach as Lambda
        allDrivers.forEach(System.out::println);        // consumer inside forEach as Method reference
    }

    @Test (dependsOnMethods = "consumerWithForEach")
    public void consumerChaining(){

        // in order to chain consumer&bi-consumers all must have same types.
        Consumer <String> dbConsumer = s -> System.out.println("Logging to db :: " + s);
        Consumer <String> consoleConsumer = s -> System.out.println("Logging to console :: " + s);
        Consumer <String> dbConsoleConsumer = dbConsumer.andThen(consoleConsumer);
        allDrivers.forEach(dbConsoleConsumer);
        allDrivers.forEach(dbConsumer.andThen(consoleConsumer));

        Map<String, Consumer<String> > consumerMap = new HashMap<>();
        consumerMap.put("db",dbConsumer);
        consumerMap.put("console",consoleConsumer);
        consumerMap.put("dbConsole", dbConsoleConsumer);

        allDrivers.forEach(consumerMap.get(System.getProperty("consumer-type")));


    }

}
