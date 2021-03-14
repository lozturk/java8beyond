package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterNullFromStream {

    public static void main (String ... args){

        List<String> programmingLanguages = Arrays.asList("Java","JavaScript",null,"Ruby",null,"pyhton",null,"Node");

        System.out.print("Before stream : " );
        programmingLanguages.forEach(x -> System.out.print(x+", "));
        System.out.println();

        System.out.print("After stream with lambda expressions : " );
        List<String> afterNull =  programmingLanguages.stream().filter(x -> x!=null).collect(Collectors.toList());
        afterNull.forEach(y -> System.out.print(y + ", "));
        System.out.println();

        System.out.print("After stream with method reference : " );
        List<String> afterNullMethodReference =  programmingLanguages.stream().filter(Objects::nonNull).collect(Collectors.toList());
        afterNullMethodReference.forEach(t -> System.out.print(t + ", "));








    }


}
