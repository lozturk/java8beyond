package Lambda.Supplier;

import org.testng.annotations.Test;

import java.util.function.Supplier;

public class SupplierExample {

    @Test
    public void supplierTest(){
        Supplier<Double> doubleNumberSupplier = () -> Math.random();
        System.out.println(doubleNumberSupplier.get());
    }

}
