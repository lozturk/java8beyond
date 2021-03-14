package streams.comparator;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ComparatorTest {

    public static void main(String[] args) {

        Student a = new Student("Adam", 80, 150);
        Student b = new Student("Bob", 96, 123);
        Student c = new Student("Carl", 75, 135);

        Optional<Student> scoreMinOptional = Stream.of(a, b, c)
                .min(Comparator.comparing(s -> s.getScore()));
        System.out.println(scoreMinOptional.get());

        Optional<Student> scoreMaxOptional = Stream.of(a, b, c)
                .max(Comparator.comparing(s -> s.getScore()));
        System.out.println(scoreMaxOptional.get());

        Optional<Student> heightMaxOptional = Stream.of(a, b, c)
                .max(Comparator.comparing(h -> h.getHeight()));
        System.out.println(heightMaxOptional.get());

        Optional<Student> nameMaxOptional = Stream.of(a, b, c)
                .max(Comparator.comparing(Student::getName));
        System.out.println(nameMaxOptional.get());

        // below is comparator example
        Comparator<Student> byName = Comparator.comparing(Student::getName);
        Optional<Student> nameMinOptional = Stream.of(a, b, c)
                .min(byName);
        System.out.println(nameMinOptional.get());




    }



}
