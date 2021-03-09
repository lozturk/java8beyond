package Streams.terminalOperations.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectGroupingBy {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("Apple");
        objects.add("Apple");
        objects.add("Airplane");
        objects.add("Ball");
        objects.add("Boy");
        objects.add("Cat");
        objects.add("Dog");
        objects.add("Delta");
        Function<String,Integer> lengthOfString = s -> s.length();
        Map<Integer, List<String>> stringLengthMap = objects.stream()
                .collect(Collectors.groupingBy(lengthOfString));
        System.out.println("String length map :: " + stringLengthMap);
        // String length map :: {3=[Boy, Cat, Dog], 4=[Ball], 5=[Apple, Apple, Delta], 8=[Airplane]}


        Function <String,Character> firstLetter = s-> s.charAt(0);
        Map<Character,List<String>> firstLetterMap = objects.stream()
                .collect(Collectors.groupingBy(firstLetter));
        System.out.println("First Letter map :: " + firstLetterMap);
        // First Letter map :: {A=[Apple, Apple, Airplane], B=[Ball, Boy], C=[Cat], D=[Dog, Delta]}




    }



}
