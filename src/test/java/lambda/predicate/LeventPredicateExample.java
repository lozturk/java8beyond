package lambda.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LeventPredicateExample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Ahmet");
        names.add("Mehmet");
        names.add("Cengiz");
        names.add("Osman");
        names.add("Ali");
        names.add("Ahmet");
        names.add("Kerim");
        names.add("Serhat");

        // Rule-1 : Remove the names with start "A"
        System.out.println("Before remove :: " + names);
//        for (int i=0; i<names.size(); i++) {
//            if (names.get(i).toUpperCase().charAt(0) == 'A'){
//                names.remove(names.get(i));
//                i--;
//            } else {
//                System.out.println(names.get(i) + "'s first letter is not equal to 'A'");
//            }
//        }


//        Predicate<String> isFirstLetterA = (name) -> name.toUpperCase().charAt(0) == 'A';
//        Predicate<String> isLastLetterT = (name) -> name.toLowerCase().endsWith("t");
//        names.removeIf(isFirstLetterA);
//        names.removeIf(isLastLetterT);
//        names.removeIf(isFirstLetterA.or(isLastLetterT));

//        Rules.getConditions().forEach(rule -> names.removeIf(rule));
        LeventRules.getConditions().forEach(names::removeIf);

        System.out.println("After remove :: " + names);

    }
}

class LeventRules {

    private static final Predicate<String> isFirstLetterA = (name) -> name.toUpperCase().charAt(0) == 'A';
    private static final Predicate<String> isLastLetterT = (name) -> name.toLowerCase().endsWith("t");

    public static List<Predicate<String>> getConditions() {
        List<Predicate<String>> listOfPredicates = new ArrayList<>();
        listOfPredicates.add(isFirstLetterA);
        listOfPredicates.add(isLastLetterT);
        return listOfPredicates;
    }

}

