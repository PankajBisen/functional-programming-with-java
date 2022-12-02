package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //filterAndPrint(numbers, number1 -> number1 % 2 == 0);

        //filterAndPrint(numbers, number -> number % 2 != 0);

        //filterAndPrint(numbers, number1 -> number1 % 3 == 0);

        List<Integer> squareNumber= mapAndCreateNewList(numbers, number -> number * number);

        List<Integer> cubeNumber= mapAndCreateNewList(numbers, number -> number * number*number);

        List<Integer> doubledNumber= mapAndCreateNewList(numbers, number -> number + number);
        System.out.println(doubledNumber);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
