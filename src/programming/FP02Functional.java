package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

//        List<Integer> squaredList = squareList(numbers);
//        System.out.println(squaredList);

        List<Integer> doubleEvenList = doubleEvenList(numbers);
        System.out.println(doubleEvenList);

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
//        int sum=addListFunctional(numbers);
//        System.out.println(sum);
    }

    private static List<Integer> squareList(List<Integer> numbers) {
        return numbers.stream()
                .map(number->number*number)
                .collect(Collectors.toList());
    }

    private static List<Integer> doubleEvenList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number->number%2==0)
                .map(number->number*number).collect(Collectors.toList());
    }


    private static int sum(int aggregate,int nextNumber){
        System.out.println(aggregate+" "+nextNumber);
        return aggregate+nextNumber;
    }
    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                //.reduce(0, FP02Functional::sum);
                //.reduce(0,(aggregate,nextNumber)->aggregate+nextNumber);
                .reduce(0,Integer::sum);
    }

}
