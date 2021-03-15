package java9;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ImmutableSet {


    @Test(priority = 1)
    public void normalList() {
        Set<Integer> normal_Set = new HashSet<>();
        normal_Set.add(1);
        normal_Set.add(2);
        normal_Set.add(3);
        normal_Set.add(4);
        normal_Set.add(null);
        System.out.println(normal_Set);
    }

    @Test (priority = 3)
    public void collectionsWithSet() {
        Set<Integer> collections_WithSet = new HashSet<>();
        Collections.addAll(collections_WithSet,1,2,3,4,null);
        System.out.println(collections_WithSet);
    }


    @Test (priority = 4)
    public void immutablesSet() {
        // if you want unmodifiable set we us this approach
        Set<String> immutable_Set = Set.of("ab","bc", "ac","de");

        // 1..this will not work, since this list is not immutable.
        immutable_Set.add("gh");
        // 2..Also this list will not accept null values.

        System.out.println(

                immutable_Set.stream()
                        .filter(s->s.contains("b"))
                        .collect(Collectors.toSet())

        );
    }
}
