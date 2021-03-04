package Streams;
// In loop you pull the data one by one
// But in stream data is pushed. Data slides and your responsibility is collect the data
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDay1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // check for even numbers
        // interested only first 3 elements
        // find the square
        // print the console one by one
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .limit(3)
                .map(i-> i * i)
                .forEach(System.out::println);

        Predicate<Integer> odd = (i)->i % 2 != 0;
        Function<Integer,Integer> cube = (i) -> i * i * i;
        Consumer<Integer> printConsole = System.out::println;
        // check for odd numbers
        // interested only first 2 members
        // find cube
        // print console one by one
        numbers.stream()
                .filter(odd)
                .limit(2)
                .map(cube)
                .forEach(printConsole);  // -> this is a Terminal operation
    }
}
