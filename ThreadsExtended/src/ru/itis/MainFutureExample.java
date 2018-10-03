package ru.itis;

import java.util.concurrent.*;

public class MainFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> sumEvenNumbersDigitsSumTask = () -> {
            int sum = 0;
            for (int i = 0; i < 100000000; i++) {
                if (i % 2 == 0) {
                    int number = i;
                    int digitSum = 0;
                    while (number != 0) {
                        digitSum = number % 10;
                        number = number / 10;
                    }
                    sum = sum + digitSum;
                }
            }
            System.out.println(Thread.currentThread().getName());
            return sum;
        };

        Callable<Integer> sumOddNumbersDigitsTask = () -> {
            int sum = 0;
            for (int i = 0; i < 100000000; i++) {
                if (i % 2 == 1) {
                    int number = i;
                    int digitSum = 0;
                    while (number != 0) {
                        digitSum = number % 10;
                        number = number / 10;
                    }
                    sum = sum + digitSum;
                }
            }
            System.out.println(Thread.currentThread().getName());
            return sum;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> futureResultEven =
                executorService.submit(sumEvenNumbersDigitsSumTask);
        Future<Integer> futureResultOdd =
                executorService.submit(sumOddNumbersDigitsTask);

        int sum1 = futureResultEven.get();
        int sum2 = futureResultOdd.get();
        System.out.println(sum1 + sum2);
    }
}
