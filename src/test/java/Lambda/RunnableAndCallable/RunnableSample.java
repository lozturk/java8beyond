package Lambda.RunnableAndCallable;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class RunnableSample {

    public static void main(String[] args) {
        // Runnable

        Runnable r = () -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("Hello world");
        };

        new Thread(r).start();

//        r.run();

        System.out.println("Hi....");

    }



}
