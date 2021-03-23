package java10;

import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableList {

    public static void main(String[] args) {

        var numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        var modifiableList = numbers.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        modifiableList.add(11); // -> after stream this list is modifiable

        modifiableList.forEach(i-> System.out.println(i));

        System.out.println("--------------------------");

        var unmodifiableList = numbers.stream()
                .filter(i->i % 2 == 0)
                .collect(Collectors.toUnmodifiableList());

        unmodifiableList.add(11); // ->  this code will give run time error. => UnsupportedOperationException

        /**
         * SIMILARLY JAVA HAS UNMODIFIABLE SET....
         */

    }
}
