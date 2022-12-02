package programming;

import java.util.List;

public class FP02Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //addSquareOfListFunctional(numbers);
        //addCubeOfListFunctional(numbers);
        //addOddListFunctional(numbers);
        addEvenListFunctional(numbers);
        //addDistinctListFunctional(numbers);
        //addSortedListFunctional(numbers);
        //addDistinctSortedListFunctional(numbers);
          /*0 12
            12 9
            21 13
            34 4
            38 6
            44 2
            46 4
            50 12
            62 15
            77*/
    }

    private static void addSquareOfListFunctional(List<Integer> numbers) {
        Integer reduce = numbers.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    private static void addCubeOfListFunctional(List<Integer> numbers) {
        Integer reduce = numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    private static void addOddListFunctional(List<Integer> numbers) {
        Integer reduce = numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
    private static void addEvenListFunctional(List<Integer> numbers) {
        Integer reduce = numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
    private static void addDistinctListFunctional(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
    private static void addSortedListFunctional(List<Integer> numbers) {
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }
    private static void addDistinctSortedListFunctional(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

}
