package Streams.terminalOperations;

import java.util.ArrayList;
import java.util.List;

public class AnyMatch {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        System.out.println(
                objects.stream()
                        .filter(s->s.length() > 3)      // there are 2 elements which satisfy the condition
                        .anyMatch(s->s.contains("e"))   // there is 1 element which satisfies the condition
                // result is true
        );
        // anyMatch() returns boolean

    }
}
