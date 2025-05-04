package Lambda.Predicate;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    @Test
    public void calculateGreaterTenAndEvenNumbersInAGivenList(){
        List<Integer> input = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<Integer> expected = List.of(10,12,14);
        calculate(input).forEach(System.out::println);
        Assert.assertEquals(calculate(input), expected,
                "The list does not contain the expected values"
        );
    }

    public List<Integer> calculate(List<Integer> numbers){
        Predicate<Integer> isGT10 = (i) -> i >= 10;
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        return numbers.stream()
                .filter(isGT10.and(isEven))
                .collect(Collectors.toList());
//        return numbers.stream()
//                .filter(i -> i >= 10 && i % 2 == 0)
//                .collect(Collectors.toList());

    }


}
