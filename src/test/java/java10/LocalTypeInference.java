package java10;

import lambda.supplier.DriverFactory;

import java.util.List;
import java.util.Map;

public class LocalTypeInference {

    private static void main(String[] args) {

    }

    // var is a local type inference so it should be used only inside a method body.
    // You should not be seeing anywhere else
    // LIMITATIONS
    // 1. declaration & value assign should be in the same line. Or else java doesn't know the type
    // 2. it can not be null value bc a string, a int, a map, a list can be null. So java can't differentiate type.
    // 3. method return, parameters; you can not use var in this places.

    private static void test() {
        int num = 10;
//        List<Integer> integers = List.of(1, 2, 3, 4, 5);
//        Map<String, Integer> names = Map.of("name1", 12, "name2", 20);

        var integers = List.of(1, 2, 3, 4, 5);
        var names = Map.of("name1", 12, "name2", 20);

        var driver = DriverFactory.getDriver("chrome"); // -> it can be WebDriver as well.

    }

    private static int testOne(){

        // "int int" will throw a compilation error, but "var var" will not
        var var = 10;
        return var;
    }
}
