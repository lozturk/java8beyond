package Streams.TerminalOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AnyMatch {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        System.out.println(
                objects.stream()
                        .filter(s->s.length() > 3)
                        .anyMatch(s->s.contains("e"))
        );
        // anyMatch() returns boolean

    }
}
