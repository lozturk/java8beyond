package Function;

import java.util.function.Function;

public class FunctionExamples {

    public static void main(String[] args) {
        // 1
        // Lambda notation
        // Function<String, Integer> giveLength = str -> str.length();
        // Method reference
        Function<String, Integer> giveLength = String::length;
        System.out.println("Length of string ::"+giveLength.apply("Levent"));

        //2
        Function<Integer,Integer> square = i -> i * i;
        System.out.println( "Square of integer :: " + square.apply(5) );

        //3
        System.out.println( giveLength.andThen(square).apply("Hi hello how are you"));
                            // 20              // 400
        // When chaining the functions, output type of first function should be
        // the same as input of second function. Or else code will complain.








    }



}
