package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 9, 6, 2, 4, 12, 15);
//      //printOddNumberINListFunctional(numbers);
        //printCubesOfOddNumberINListFunctional(numbers);
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices",
                "AWS", "PCF", "Docker", "Kubernetes");
//        courses.stream().forEach(System.out::println);

//        courses.stream()
//                .filter(course->course.contains("Spring"))
//                .forEach(System.out::println);

//        courses.stream()
//                .filter(course -> course.length()>=4)
//                .forEach(System.out::println);

//        courses.stream()
//                .map(course->course+" "+course.length())
//                .forEach(System.out::println);

//        courses.stream()
//                .sorted()
//                .forEach(System.out::println);

//        courses.stream()
//                .sorted(Comparator.naturalOrder())
//                .forEach(System.out::println);
//        courses.stream()
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);

//        courses.stream()
//                .sorted(Comparator.comparing(str->str.length()))
//                .forEach(System.out::println);

        List<Integer> collect = courses.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void printOddNumberINListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)//Lambda Expression
                .forEach(System.out::println);//Method Reference
    }
    private static void printCubesOfOddNumberINListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)//Lambda Expression
                .map(number->number*number*number)
                .forEach(System.out::println);//Method Reference
    }

}
