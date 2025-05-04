package lambda.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionListToMap {

    public static void main(String[] args) {

        List<String> countries = Arrays.asList("Turkey","United States","France","Canada");
        Function<String,Integer> strToInt = (s) -> s.length();
        System.out.println(listToMap(countries,strToInt));
 }

    public static <S,I> Map<S,I> listToMap (List <S> lst, Function <S,I> fn){
        Map<S,I> stringIntegerMap = new HashMap<>();
        for (S str : lst) {
            stringIntegerMap.put(str, fn.apply(str));
        }
        return stringIntegerMap;
    }



}
