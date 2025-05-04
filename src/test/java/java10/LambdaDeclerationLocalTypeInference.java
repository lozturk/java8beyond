package java10;

import java.util.function.Consumer;

public class LambdaDeclerationLocalTypeInference {

    public static void main(String[] args) {

    }

    private static void testOne(int a, int b) {
        Consumer<Integer> doubleIt = (i) -> System.out.println(i + i);
        doubleIt.accept(a);
    }
    /**
     * We can NOT use var lambda expressions
     * If we use var Java does NOT understand the type here. It could be int, string, dog, student and
     * it could be anything. So this will give compilation error.
     * Lambda => Implementation of functional interface, implementation of single abstract method interface.
     * So it does not know type, so it does not know return values or null.
     * So it desires, it has to know all those things based on the left hand side which is declaration.
     * In above example java knows it's a consumer and type is Integer but in below example java doesn't know it.
     * Also java doesn't know which functional interface will be implemented. There are tons of interfaces.
     * So Java gets confused.
     * WE CAN NOT USE VAR FOR LAMBDA DECLARATION.
     */

    private static void testTwo(int a, int b) {
//        var doubleIt = (i) -> System.out.println(i+i);
//        doubleIt.accept(a);
    }

    // below is multi line lambda and VAR can be used in the method body without any issue.
    private static void testThree(int a, int b) {
        Consumer <Integer> doubleIt = (i) -> {
            var num = 10;
            System.out.println(i + i + num);
        };
        doubleIt.accept(a);
    }
}
