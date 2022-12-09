package programming;

import java.util.stream.IntStream;

public class FP06Threads {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <1000; i++) {
//                    System.out.println(Thread.currentThread().getId() + ":" + i);
//                }
//            }
//        };
//        Runnable runnable2 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getId() + ":" + i);
//            }
//        };
        Runnable runnable3 = () -> {
            IntStream.range(0,1000).forEach(e->System.out.println(Thread.currentThread().getId() + ":" + e));
        };
        Thread thread = new Thread(runnable3);
        thread.start();

        Thread thread1 = new Thread(runnable3);
        thread1.start();

        Thread thread2 = new Thread(runnable3);
        thread2.start();

    }
}
