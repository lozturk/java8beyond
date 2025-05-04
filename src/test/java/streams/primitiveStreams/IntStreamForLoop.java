package streams.primitiveStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamForLoop {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,1,2,3,4,5,6,7,8,9,10);

        // IntStream will replace our traditional for loop

        IntStream.rangeClosed(1,10)                                 // 10 is inclusive
                .forEach(i-> System.out.println("Levent : " + i));

        IntStream.range(1,10)                                       // 10 is exclusive
                .forEach(i-> System.out.println("Levent : " + i));

        IntStream.rangeClosed(1,nums.size())
                .forEach(i-> {
                    System.out.println("Levent : " + i);
                    System.out.println("Ozturk : " + i);
                });


    }


}
