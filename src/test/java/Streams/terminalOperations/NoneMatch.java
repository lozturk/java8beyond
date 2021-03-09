package Streams.terminalOperations;

import java.util.ArrayList;
import java.util.List;

public class NoneMatch {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("ball");
        objects.add("cat");
        objects.add("dog");

        System.out.println(
                objects.stream()
                        .filter(s->s.length() > 3)      // there are 2 elements which satisfy the condition
                        .noneMatch(s->s.contains("e"))  // there is NO element which satisfy the condition
                // result is false
        );
        // anyMatch() returns boolean

    }
}
