package programming;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperation {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .distinct()//Stream<T> Intermediate
                .sorted()//Stream<T>
                .forEach(System.out::println);//void terminal

        List<Integer> squareList=numbers.stream()
                .map(number->number*number)//Stream<T>
                .collect(Collectors.toList());//R

        List<Integer> doubleEvenList=numbers.stream()
                .filter(number->number%2==0)//Stream<T>
                .map(number->number*number).collect(Collectors.toList());


        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices",
                "AWS", "PCF", "Docker", "Kubernetes");

        List<String> coursesSorted=courses.stream()
                .sorted(Comparator.comparing(str->str.length()))
                .collect(Collectors.toList());

    }
}
