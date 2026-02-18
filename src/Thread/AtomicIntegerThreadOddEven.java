package Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class AtomicIntegerThreadOddEven {
    private final AtomicInteger number = new AtomicInteger(1);
    private final int LIMIT = 30;
    public final static Map<Integer, String> cache = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerThreadOddEven printer = new AtomicIntegerThreadOddEven();
        Thread odd1 = new Thread(printer::printOdd, "Odd-1");
        Thread odd2 = new Thread(printer::printOdd, "Odd-2");
        Thread even1 = new Thread(printer::printEven, "Even-1");
        Thread even2 = new Thread(printer::printEven, "Even-2");
        odd1.start();
        odd2.start();
        even1.start();
        even2.start();
        // ✅ Wait for all threads
        odd1.join();
        odd2.join();
        even1.join();
        even2.join();
        System.out.println(cache);
    }

    public void printOdd() {
        while (true) {
            int current = number.get();
            if (current > LIMIT) return;
            if (current % 2 != 0 && number.compareAndSet(current, current + 1)) {
                System.out.println(Thread.currentThread().getName() + " -> " + current);
                cache.put(current, Thread.currentThread().getName());
            }
        }
    }

    public void printEven() {
        while (true) {
            int current = number.get();
            if (current > LIMIT) return;
            if (current % 2 == 0 && number.compareAndSet(current, current + 1)) {
                System.out.println(Thread.currentThread().getName() + " -> " + current);
                cache.put(current, Thread.currentThread().getName());
            }
        }
    }
}
