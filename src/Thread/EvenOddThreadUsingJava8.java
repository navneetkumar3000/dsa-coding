package Thread;

public class EvenOddThreadUsingJava8 {
    private static final Object lock = new Object();
    private static int num = 1;
    private static final int LIMIT = 20;
    public static void main(String[] args) {
          Thread oddThread = new Thread(() -> {
              while (num <= LIMIT){
                  synchronized (lock){
                      if(num % 2 == 1){
                          System.out.println("Odd Number : " + num++);
                          lock.notify();
                      } else {
                          try {
                              lock.wait();
                          } catch (Exception e){
                              Thread.currentThread().interrupt();
                          }
                      }
                  }
              }
          });
        Thread evenThread = new Thread(() -> {
            while (num <= LIMIT){
                synchronized (lock){
                    if(num % 2 == 0){
                        System.out.println("Even Number : " + num++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e){
                            Thread.currentThread().interrupt();
                        }
                    }

                }
            }
        });
        oddThread.start();
        evenThread.start();
    }
}
