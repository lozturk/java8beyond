package Streams.PrimitiveStreams;

import java.util.*;
import java.util.stream.IntStream;

public class IntStreamSample {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,1,2,3,4,5,6,7,8,9,10);

        // IntStream is a stream type for primitive int
        // Stream<Integer> is a stream type for Reference type Integer. This type of stream is generic.
        // It could be Stream<Integer>, Stream<String>, etc...

        int sum = nums.stream()
                .mapToInt(num->num)
                .sum();
        System.out.println("Sum:: " + sum);

        OptionalDouble average = nums.stream()
                .mapToDouble(num -> num)
                .average();
        System.out.println("Average:: " + average);

    }


}
