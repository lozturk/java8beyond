package Assignments.endOfUnit8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstNameAssignment {

    public static void main(String[] args) {
        //  /Users/lozturk/IdeaProjects/java8beyond/FilesForProject/first-names.txt
        Path pathToNamesFile = Paths.get("/Users/lozturk/IdeaProjects/java8beyond/FilesForProject/first-names.txt");
        try {
            // print the count of names which starts with B
            List<String> namesFromFile = Files.readAllLines(pathToNamesFile);
            System.out.println("namesFromFile:: "+ namesFromFile);
            List<String> namesStartWithB = namesFromFile.stream()
                    .filter(n -> n.startsWith("B"))
                    .collect(Collectors.toList());
            System.out.println(namesStartWithB.size());

            System.out.println(namesFromFile.stream()
                    .filter(n -> n.startsWith("B"))
                    .count()
            );

            // create a list of names which starts with C and contains 's' in it
            List<String> startsWithC = namesFromFile.stream()
                    .filter(n -> n.startsWith("C"))
                    .filter(n-> n.contains("s"))
                    .collect(Collectors.toList());
            System.out.println(startsWithC);
            System.out.println(startsWithC.size());

            List<Integer> startsWithM = namesFromFile.stream()
                    .filter(n -> n.startsWith("M"))
                    .map(n-> n.trim())
                    .map(n-> n.length())
                    .collect(Collectors.toList());
            int sum = startsWithM.stream().mapToInt(i->i).sum();
            System.out.println("Sum startWithM one :: "+ sum);

            System.out.println( "Sum startWithM two :: "+
                    namesFromFile.stream()
                            .filter(n -> n.startsWith("M"))
                            .map(String::trim)
                            .map(String::length)
                            .mapToInt(i->i)
                            .sum()
            );

            // find the names contains "-" and replace them with space and collect them into a list
            List<String> namesContainsDash = namesFromFile.stream()
                    .filter(name->name.contains("-"))
                    .map(name->name.replace("-"," "))
                    .collect(Collectors.toList());
            System.out.println("namesContainsDash :: "+ namesContainsDash);

            // find the name which has more number of chars
            System.out.println(

                    namesFromFile.stream()
                            .max(Comparator.comparing(name->name.length()))
                            .get()
            );



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}