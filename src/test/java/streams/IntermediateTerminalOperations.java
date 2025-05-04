package streams;

import java.util.Arrays;
import java.util.List;

public class IntermediateTerminalOperations {

    // Intermediate --> Behaviour :: Returns new streams & Lazy - stream only work if there is a terminal operator.
    // if you don't put a bucket under the stream pipeline then the fountain will not run the water.
    // 1_filter, 2_map, 3_limit, 4_skip, 5_distinct, 6_sorted, 7_flatMap, 8_peek

    // Terminal operations --> Stream is consumed & can NOT bu reused
    // 1_forEach, 2_collect, 3_count, 4_min, 5_max, 6_findAny, 7_anyMatch, 8_noneMatch

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // check for even numbers
        // interested only first 3 elements
        // find the square
        // print the console one by one
        numbers.stream()
                .skip(2)
                .peek(integer -> System.out.println("Filter received :: " + integer))
                .filter(i -> i % 2 == 0)
                .filter(i-> i > 5)
                .sorted()       // sorted behaviour is different than others,
                .peek(i -> System.out.println("After sorted::" + i))
                .limit(2)       // once all elements sorted then it will let them continue into the pipeline
                .map(i-> i * i)
                .map(i -> i + 2)
                .forEach(System.out::println);

    }







}
