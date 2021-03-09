package lambda.predicate;

import org.testng.annotations.Test;

import java.util.function.Predicate;

/*
Lambda.Predicate use generic input types
It returns a boolean if condition is satisfied
it has test() method
Chaining is possible with and(Lambda.Predicate), or(Lambda.Predicate) & negate() methods
There is BiPredicate<T,R>
It is very useful if you need to check certain conditions
*/
public class PredicateExamples {

    @Test
    public void predicateTest(){

        Predicate<Integer> isGT2 = (i) -> i > 2;
        Predicate<Integer> isLD10 = (i) -> i < 10;

        System.out.println(
                isGT2.and(isLD10).test(67)
        );

        System.out.println(

                isGT2.negate().test(78)

        );

    }


}
