package streams.isNotReusable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class notReusable {
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
        Predicate<String> longerThan3Chars = s -> s.length() > 3;
        Stream<String> stream = objects.stream()
                .filter(longerThan3Chars);
        stream.forEach(System.out::println);
        stream.forEach(s -> System.out.println(s.toUpperCase()));

        // for the second forEach(), we will get below message:
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
    }



}
