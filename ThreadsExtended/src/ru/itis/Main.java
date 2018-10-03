package ru.itis;

public class Main {

  public static void main(String[] args) throws InterruptedException {
      ThreadPool pool = new ThreadPool(3);

      Runnable sayHello = () -> {
        for (int i = 0; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + "Hello");
        }
      };

      Runnable sayBye = () -> {
        for (int i = 0; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + "Bye");
        }
      };

      Runnable sayMarsel = () -> {
        for (int i = 0; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + "Marsel");
        }
      };

      pool.submitTask(sayHello);
      pool.submitTask(sayBye);
      pool.submitTask(sayMarsel);

  }
}
