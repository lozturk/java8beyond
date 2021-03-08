package Streams.StreamSource;

import java.util.Comparator;
import java.util.stream.Stream;

public class SourceOfStream {

    public static void main(String[] args) {

        String a = "Ball";
        String b = "Delta";
        String c = "Apple";

        System.out.println(

                Stream.of(a,b,c)
                .min(Comparator.naturalOrder())
        );
    }

}
