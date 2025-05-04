package java10;

import java.util.ArrayList;
import java.util.List;

public class VarInGenerics {

    public static void main(String[] args) {

        List <Integer> numbers = List.of(1,2,3,4,5);
        // we can use var here.
        var numbers2 = List.of(1,2,3,4,5);

        // if we use for specific type then we need to declari it on the right hand side while using lambda
        // or else java will create a List of Objects instead of List of Integers.

        var number3 = new ArrayList<Integer>();
        number3.add(1);
//        number3.add("vinoth");
    }



}
