package streams.terminalOperations.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectToList {

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
        List<String> objectLongerThan3Chars = objects.stream()
                .filter(isLonger3Chars)
                .collect(Collectors.toList());

        System.out.println("Original list                   :: " + objects);
        System.out.println("String longer than 3 chars list :: " + objectLongerThan3Chars);

    }

}
