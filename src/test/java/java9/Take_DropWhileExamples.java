package java9;

import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Take_DropWhileExamples {

    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of(4, 2, 1, 4, 2, 5, 1, 1, 2, 1, 3, 5, 2, 1);
        Stream<Integer> numbers2 = Stream.of(4, 2, 1, 4, 2, 5, 1, 1, 2, 1, 3, 5, 2, 1);
        Stream<Integer> numbers3 = Stream.of(4, 2, 1, 4, 2, 5, 1, 1, 2, 1, 3, 5, 2, 1);


        System.out.println("This is stream    : "+numbers.collect(Collectors.toList()));
        System.out.println(
                "This is takeWhile : "+
                        numbers2
                                .takeWhile(i->i<5)             // once the condition is satisfied, it will exit with matching values
                                .collect(Collectors.toList())  // less than 5; then take it, take it so far so on......
        );
        System.out.println(
                "This is dropWhile :                "+
                        numbers3
                        .dropWhile(i->i<5)             // once the condition is satisfied, it will exit with non-matching values
                        .collect(Collectors.toList())  // less than 5; then drop it, drop it so far so on......
        );



    }
}
