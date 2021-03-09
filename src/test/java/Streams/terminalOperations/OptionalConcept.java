package Streams.terminalOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalConcept {
    public static void main(String[] args) {

        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        // OPTIONAL CONCEPT : Stream says that there is a chance that
        // there may not be any elements which satisfy your condition.
        System.out.println("----------2nd line----------");
        Predicate<String> longerThan10Chars = s -> s.length() > 10;
        System.out.println(
                objects.stream()
                        .filter(longerThan10Chars)
                        .findFirst()
        );  // console output is::  Optional.empty

        System.out.println("----------3th line----------");
        Optional<String> opt = objects.stream()
                .filter(longerThan10Chars)
                .findFirst();

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

//        opt.ifPresent(System.out::println);   <<== This is functional style expression

    }
}
