package Streams.TerminalOperations.Collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectJoining {

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
        String joinedString = objects.stream()
                .filter(isLonger3Chars)
                .collect(Collectors.joining(";"));

        System.out.println("Joined string :: " + joinedString);

        // Output ==>> Joined string :: Apple;Apple;Airplane;Ball;Delta


    }
}
