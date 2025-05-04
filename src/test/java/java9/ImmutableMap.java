package java9;

import org.testng.annotations.Test;

import java.util.*;

public class ImmutableMap {

    @Test
    public void immutablesMap() {
        // if you want unmodifiable list we us this approach
        Map<String,Integer> immutable_Map = Map.of(
                "a",15,
                "b",34,
                "c",100
//                null,400
        );

        // 1..this will not work, since this list is not immutable.
//        immutable_Map.put("d",234);
        // 2..Also this list will not accept null values.

        System.out.println(immutable_Map);
    }
}
