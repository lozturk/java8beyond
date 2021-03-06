package Streams.TerminalOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MinAndMax {
    public static void main(String[] args) {

        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        System.out.println(
                objects.stream()                            // Stream<String>
                        .min(Comparator.naturalOrder())     // Optional<String>
                        .get()                              // to get the String, we use get() method.
        );
        // Natural order is ascending. Min will give us the FIRST element. So console output is::  apple

        System.out.println("----------2nd line----------");
        Optional<String> opt2 = objects.stream()
                .min(Comparator.reverseOrder());
        opt2.ifPresent(System.out::println);
        // Reverse order is descending. Min will give us the FIRST element.So console output is::  dog


        System.out.println("----------3th line----------");
        Optional<String> opt3 = objects.stream()
                .max(Comparator.naturalOrder());
        opt3.ifPresent(System.out::println);
        // Natural order is ascending. Max will give us the LAST element. So console output is::  dog


        System.out.println("----------4th line----------");
        Optional<String> opt4 = objects.stream()
                .max(Comparator.reverseOrder());
        opt4.ifPresent(System.out::println);
        // Reverse order is descending. Max will give us the LAST element. So console output is::  apple

        System.out.println("----------5th line----------");
        Predicate<String> longerThan3Chars = s -> s.length() > 3;
        System.out.println(

                objects.stream()
                .filter(longerThan3Chars)
                .min(Comparator.naturalOrder())
                .get()

        );


    }

}
