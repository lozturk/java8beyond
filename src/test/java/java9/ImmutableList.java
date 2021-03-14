package java9;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableList {

    @Test (priority = 1)
    public void normalList() {
        List<Integer> normal_List = new ArrayList<>();
        normal_List.add(1);
        normal_List.add(2);
        normal_List.add(3);
        normal_List.add(4);
        normal_List.add(null);
        System.out.println(normal_List);
    }

    @Test (priority = 2)
    public void arrayWithList() {
        List<Integer> array_WithList = Arrays.asList(1,2,3,4,null);
        System.out.println(array_WithList);
    }

    @Test (priority = 3)
    public void collectionsWithList() {
        List<Integer> collections_WithList = new ArrayList<>();
        Collections.addAll(collections_WithList,1,2,3,4,null);
        System.out.println(collections_WithList);
    }


    @Test (priority = 4)
    public void immutablesList() {
        // if you want unmodifiable list we us this approach
        List<Integer> immutable_List = List.of(1, 2, 3, 4);

        // 1..this will not work, since this list is not immutable.
        immutable_List.add(5);
        // 2..Also this list will not accept null values.

        System.out.println(immutable_List);
    }


}
