package streams.terminalOperations;

import java.util.ArrayList;
import java.util.List;

public class AllMatch {

    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("apple");
        objects.add("bell");
        objects.add("cat");
        objects.add("dog");
        objects.add("tiger");
        objects.add("grape");
                                        // anyMatch() returns boolean
        System.out.println(
                objects.stream()
                        .filter(s->s.length() > 3)      // there are 4 elements which satisfy the condition
                        .allMatch(s->s.contains("e"))   // there are 4 elements which satisfy the condition
                // result is true
        );

        System.out.println("--------------------");

        List<String> secondObjects = new ArrayList<>();
        secondObjects.add("apple");
        secondObjects.add("ball");
        secondObjects.add("cat");
        secondObjects.add("dog");
        secondObjects.add("tiger");
        secondObjects.add("grape");
                                            // anyMatch() returns boolean
        System.out.println(
                secondObjects.stream()
                        .filter(s->s.length() > 3)      // there are 4 elements which satisfy the condition
                        .allMatch(s->s.contains("e"))   // there is one element which NOT satisfies the condition
                // result is false
        );


    }
}
