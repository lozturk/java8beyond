package Streams.terminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindFirst {

    public static void main(String[] args) {

        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        System.out.println(
                objects.stream().count()   // this is same as size() method
        );

        System.out.println("---------1st line-----------");

        // found the first member of objects which is longer then 3 characters
        Predicate<String> longerThan3Chars = s -> s.length() > 3;
        System.out.println(
                objects.stream()
                        .filter(longerThan3Chars)
                        .findFirst()
        );
    }
}
