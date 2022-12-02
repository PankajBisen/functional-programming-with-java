package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;
        Predicate<Integer> isEvenPredicate2=new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = number -> number * number;
        Function<Integer, Integer> squareFunction2 =new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number*number;
            }
        };
        Consumer<Integer> sysoutConsumer = System.out::println;
        Consumer<Integer> sysoutConsumer2 =new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };
        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 =new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer number1, Integer number2) {
                return number1+number2;
            }
        };
        int sum=numbers.stream().filter(isEvenPredicate2)
                .reduce(0, sumBinaryOperator);

    }
}
