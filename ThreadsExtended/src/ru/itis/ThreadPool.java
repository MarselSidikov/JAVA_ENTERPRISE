package ru.itis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool {

  // количество потоков
  private final int threadsCount;

  // массив потоков
  private final ThreadWorker threads[];

  // очередь задач
  private final Deque<Runnable> tasks;

  // конструктор, принимает на вход
  // необходимое количество потоков
  public ThreadPool(int threadsCount) {
    this.threadsCount = threadsCount;
    // создали пустую очередь задач
    tasks = new ConcurrentLinkedDeque<>();
    // создали массив переменных
    // для потоков пула
    threads = new ThreadWorker[threadsCount];
    // пробегаем по каждому элементу массива
    for (int i = 0; i < threadsCount; i++) {
      // создаем поток
      threads[i] = new ThreadWorker();
      // запускаем поток
      threads[i].start();
    }
  }
  // кладем задачу
  public void submitTask(Runnable task) {
    // блокирует очередь задач
    synchronized (tasks) {
      // кладет задачу
      tasks.add(task);
      // говорит, всем потокам что освободил очередь
      // но реагирует только один
      tasks.notifyAll();
    }
  }

  // один из потоков пула
  private class ThreadWorker extends Thread {
      public void run() {
          // текущая задача, которую хочет взять на исполнение
          // какой-либо PoolWorker
          Runnable task;

          // бесконечный цикл
          while (true) {
              // блокируем очередь задач
              synchronized (tasks) {
                  // если очередь пустая
                  while (tasks.isEmpty()) {
                      try {
                          // уходим в ожидание освобождая монитор
                          tasks.wait();
                      } catch (InterruptedException e) {
                          throw new IllegalStateException(e);
                      }
                  }
              }
              task = tasks.removeFirst();
              task.run();
          }
      }
  }
}
