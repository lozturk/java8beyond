package RunnableAndCallable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CallableSample {

    public static void main(String[] args) throws Exception {

        Supplier<Double> random1 = Math::random;
        Callable<Double> random2 = Math::random;


        System.out.println(random1.get());
        try {
            System.out.println(random2.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // or throw exception in method signature.

        System.out.println("---------------------------------------");

        test(random2);



    }

    public static void test (Callable callable) throws Exception {
        System.out.println(
                callable.call()
        );
    }


}
