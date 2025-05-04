package streams.optional;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {


    @Test
    public static void withoutOptional(){

        String a = "Ball";
        String b = "Delta";
        String c = "Apple";

        System.out.println(
                getSmallestWithoutOptional(a,b,c).toUpperCase()
        );

    }
    private static String getSmallestWithoutOptional(String s1, String s2, String s3){
        // some algorithm to find the smallest
        return null;
        // There is a chance that this method will not return String each time instead it might return null,
        // so the developer can not use the uppercase() straight. he/she needs to be careful, we used to get a lot of "nullpointerException"
    }

    // OUTPUT WILL BE ::: Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toUpperCase()"
    // because the return value of "Streams.Optional.OptionalExample.getSmallest(String, String, String)" is null
    // at Streams.Optional.OptionalExample.main(OptionalExample.java:17)

    @Test
    // there is no exception, since we force people to check the null possibility
    public static void withOptional(){
        String a = "Ball";
        String b = "Delta";
        String c = "Apple";
        Optional<String> smallestWithOptional = getSmallestWithOptional(a, b, c);
        if (smallestWithOptional.isPresent())
            System.out.println(smallestWithOptional.get());
    }

    private static Optional<String> getSmallestWithOptional(String s1, String s2, String s3){
        // some algorithm to find the smallest
        return Optional.ofNullable(null);
    }


    @Test
    // thi swill not throw any exception
    public static void withOptionalWithStream(){
        String a = "Ball";
        String b = "Delta";
        String c = "Apple";
        Optional<String> smallestWithOptionalWithStream = getSmallestWithOptionalWithStream(a, b, c);
        if (smallestWithOptionalWithStream.isPresent())
            System.out.println(smallestWithOptionalWithStream.get().toUpperCase());
    }

    private static Optional<String> getSmallestWithOptionalWithStream(String s1, String s2, String s3){
        // some algorithm to find the smallest
        return Stream.of(s1,s2,s3).min(Comparator.naturalOrder());
    }
}

    // OPTIONAL FORCES THE USER TO CHECK NULL.