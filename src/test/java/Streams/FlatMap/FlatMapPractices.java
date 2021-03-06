package Streams.FlatMap;
// FlatMAp is generally used with list of list
// if we want to deal with each & every element in the list one by one
// then we use flatMAp
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlatMapPractices {
    public static void main(String[] args) {
        List <Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List <Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);

        List <Integer> c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);

        List<List<Integer>> parentList = new ArrayList<>();
        parentList.add(a);
        parentList.add(b);
        parentList.add(c);

        parentList.stream()
                .forEach(l-> System.out.println(l));
        // flatMAp is providing to get everything one by one.
        System.out.println("--------Lambda expression---------");
        parentList.stream()
                .flatMap(l->l.stream())
                .forEach(i-> System.out.println(i));


        System.out.println("--------Method reference---------");
        parentList.stream()
                .flatMap(Collection::stream)
                .map(i->i * i)
                .forEach(System.out::println);






    }



}
