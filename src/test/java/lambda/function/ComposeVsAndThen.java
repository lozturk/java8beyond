package lambda.function;

import java.util.function.Function;

public class ComposeVsAndThen {

    public static void main(String[] args) {


        Function<Integer, Integer> plus2 = (i) -> i + 2;
        Function<Integer,Integer> square = i -> i * i;

        //1 AndThen example
        System.out.println( plus2.andThen(square).apply(8));
                            // 10         // 100
        //2 Compose example
        System.out.println( plus2.compose(square).apply(8));
                            // 66         // 64

        // ORDER OF EXECUTION.
        // a.andThen(b) => a -> b
        // c.compose(b) => b -> a








    }
}
