package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 9, 6, 2, 4, 12, 15);
        //printAllNumberINListFunctional(numbers);
        //printEvenNumberINListFunctional(numbers);
        printSquareOfEvenNumberINListFunctional(numbers);
    }
    /*private static void print(int number) {
        System.out.println(number);
    }*/
    /*private static boolean isEven(int number){
        return number%2==0;
    }*/
    private static void printAllNumberINListFunctional(List<Integer> numbers) {
        /*for(int number:numbers){
            System.out.println(number);
        }*/
        numbers.stream()
                .forEach(System.out::println);//Method Reference
    }
    private static void printEvenNumberINListFunctional(List<Integer> numbers) {
        numbers.stream()
                //.filter(FP01Functional::isEven)//filter - only allow even number
                .filter(number->number%2==0)//Lambda Expression
                .forEach(System.out::println);//Method Reference
    }
    private static void printSquareOfEvenNumberINListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number->number%2==0)//Lambda Expression
                .map(number->number*number)
                .forEach(System.out::println);//Method Reference
    }
}
