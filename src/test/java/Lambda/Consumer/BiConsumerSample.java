package Lambda.Consumer;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerSample {

    @Test
    public void biConsumerExample(){



        BiConsumer<String,Integer> sample = (s, i) -> {
            System.out.println("My name is :: " + s);
            System.out.println("My age is :: " + i);
        };

        sample.accept("Jonathan",55);

        System.out.println("-----------------");


        Map<String,Integer> employee = new HashMap<>();
        employee.put("Levent",44);
        employee.put("Derrick",46);
        employee.put("Tino",49);
        employee.put("Lakshmi",43);
        employee.put("Betul",40);

        employee.forEach(sample);




    }





}
