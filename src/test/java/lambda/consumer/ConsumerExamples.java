package lambda.consumer;

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
//        Lambda.Consumer <String> displayDrivers = (d) -> System.out.println(d); // Lambda
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

    @Test
    public void consumerTest(){

        Consumer <String> printAcceptedString = System.out::println;
        printAcceptedString.accept("Levent");

        List<String> countries = new ArrayList<>();
        countries.add("United States");
        countries.add("India");
        countries.add("Turkey");
        countries.add("Afghanistan");

        /**
         * This is the first style
         */

        for (String country: countries) {
            System.out.println(country.toUpperCase());
        }

        /**
         * This is the second style.
         * Data comes from list and
         * behaviour is specified inside the foreach method
         */

        Consumer<String> countryBehaviourOne = (s) -> System.out.println(s.toUpperCase());
        countries.forEach(countryBehaviourOne);

        /**
         * This is the third style.
         * Data comes from list and
         * behaviour is specified inside the foreach method
         */

        countries.forEach(s -> System.out.println(s.toUpperCase()));
        Map<String,Integer> stringIntegerMap = new HashMap<>();
        Consumer<String> getLength = s -> {
            int lngth = s.length();
            stringIntegerMap.put(s,lngth);
        };

        getLength.accept("Levent");
        countries.forEach(getLength);
        System.out.println(stringIntegerMap);
    }

}
