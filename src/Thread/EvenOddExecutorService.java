package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddExecutorService {
    private static int num = 1;
    private static final int LIMIT = 20;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //Odd Thread
        Runnable oddThread = () -> {
          while (num <= LIMIT) {
              synchronized (lock) {
                  if (num % 2 == 1) {
                      System.out.println("ODD : " + num++);
                      lock.notify();
                  } else {
                      try {
                          lock.wait();
                      } catch (Exception e) {
                          Thread.currentThread().interrupt();
                      }
                  }
              }
          }
        };

        //Even Thread
        Runnable evenThread = () -> {
            while (num <= LIMIT) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println("EVEN : " + num++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        };

        executor.submit(oddThread);
        executor.submit(evenThread);

        executor.shutdown();
    }
}
