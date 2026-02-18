package Thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentalThreadOddEven {
    private int number = 1;
    private final int LIMIT = 30;
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    public static Map<Integer, String> cache = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        ReentalThreadOddEven printer = new ReentalThreadOddEven();
        Thread odd1 = new Thread(printer::printOdd, "Odd-1");
        Thread odd2 = new Thread(printer::printOdd, "Odd-2");
        Thread even1 = new Thread(printer::printEven, "Even-1");
        Thread even2 = new Thread(printer::printEven, "Even-2");
        odd1.start();
        odd2.start();
        even1.start();
        even2.start();
        // ✅ wait for threads
        odd1.join();
        odd2.join();
        even1.join();
        even2.join();
        System.out.println("\n===== CACHE CONTENT =====");
        System.out.println(cache);
    }

    public void printOdd() {
        while (true) {
            lock.lock();
            try {
                if (number > LIMIT) {
                    evenCondition.signalAll();
                    return;
                }
                while (number % 2 == 0) {
                    oddCondition.await();
                    if (number > LIMIT) {
                        evenCondition.signalAll();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Reental " + number);
                cache.put(number, Thread.currentThread().getName());
                number++;
                evenCondition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (true) {
            lock.lock();
            try {
                if (number > LIMIT) {
                    oddCondition.signalAll();
                    return;
                }
                while (number % 2 != 0) {
                    evenCondition.await();
                    if (number > LIMIT) {
                        oddCondition.signalAll();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Reental " + number);
                cache.put(number, Thread.currentThread().getName());
                number++;
                oddCondition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}