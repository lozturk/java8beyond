package Streams.TerminalOperations.Collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectToSet {

    public static void main(String[] args) {

        List<String> objects = new ArrayList<>();
        objects.add("Apple");
        objects.add("Apple");
        objects.add("Airplane");
        objects.add("Ball");
        objects.add("Boy");
        objects.add("Cat");
        objects.add("Dog");
        objects.add("Delta");

        Predicate<String> isLonger3Chars = s -> s.length() > 3;
        Set<String> objectLongerThan3Chars = objects.stream()
                .filter(isLonger3Chars)
                .collect(Collectors.toSet());

        System.out.println("Original set                   :: " + objects);
        System.out.println("String longer than 3 chars set :: " + objectLongerThan3Chars);

        // set doesn't follow the order, but it increases the performance.

    }
}
