package ru.itis;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(3);

    service.submit(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName());
      }
    });

    service.submit(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName());
      }
    });

    service.submit(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName());
      }
    });
  }
}
