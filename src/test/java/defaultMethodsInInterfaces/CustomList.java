package defaultMethodsInInterfaces;

import java.util.function.Consumer;

public interface CustomList {

    // List interface has 3 abstract methods

    void add(int item);
    int size();
    int get(int index);


    // benefit of default method is
    //  a/ Developers are able to add new methods to existing interfaces without any problem
    //  b/ existing interfaces will not be broken
    default void forEach(Consumer <Integer> consumer){
        for (int i=0; i<size(); i++){
            consumer.accept(get(i));
        }
    }

    // after java8 interfaces can have default methods
    // interfaces can have static methods
    // Class, abstract class & interfaces can have static methods



}
