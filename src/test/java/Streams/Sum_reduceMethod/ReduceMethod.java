package Streams.Sum_reduceMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReduceMethod {

    public static void main(String[] args) {

        List <Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,1,2,3,4,5,6,7,8,9,10);

        int sum = 0;
        for (int i : numbers) {
            sum = sum + i;
        }
        System.out.println(sum);
        System.out.println();

//        numbers.forEach(i -> {
//            sum = sum + i;              // this code will complain since a new variable
//        });                             // can't be assigned from out of scope of the lambda


        // REDUCE WILL HELP YOU TO REDUCE/COMBINE EVERYTHING INTO ONE SINGLE OBJECT
        // SO YOU HAVE TO TELL HOW YOU WANT TO COMBINE

        Optional<Integer> reduce_sum = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println(reduce_sum.get());
        System.out.println("Let's have a look at the reduce logic...");

        // Let's have a look at the reduce logic...
        Optional<Integer> reduce_sum_ = numbers.stream()
                .reduce((a, b) -> {
                    System.out.println(a+"::"+b);
                    return a + b;
                });
        System.out.println(reduce_sum_.get());

    }
}
