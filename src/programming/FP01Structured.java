package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 9, 6, 2, 4, 12, 15);
        //printAllNumberINListStructured(numbers);
        printEvenNumberINListStructured(numbers);
    }

    private static void printAllNumberINListStructured(List<Integer> numbers) {
        for(int number:numbers){
            System.out.println(number);
        }
    }

    private static void printEvenNumberINListStructured(List<Integer> numbers) {
        for(int number:numbers){
            if(number%2==0){
                System.out.println(number);
            }
        }
    }
}
