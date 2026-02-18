package Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ExecutorOddEven {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger number = new AtomicInteger(1);
        int LIMIT = 30;

        Map<Integer, String> cache = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Runnable oddTask = () -> {
            while (true) {
                int current = number.get();
                if (current > LIMIT) break;

                if (current % 2 != 0 &&
                        number.compareAndSet(current, current + 1)) {

                    System.out.println(Thread.currentThread().getName() + " -> " + current);
                    cache.put(current, Thread.currentThread().getName());
                }
            }
        };

        Runnable evenTask = () -> {
            while (true) {
                int current = number.get();
                if (current > LIMIT) break;

                if (current % 2 == 0 &&
                        number.compareAndSet(current, current + 1)) {

                    System.out.println(Thread.currentThread().getName() + " -> " + current);
                    cache.put(current, Thread.currentThread().getName());
                }
            }
        };

        executor.submit(oddTask);
        executor.submit(oddTask);
        executor.submit(evenTask);
        executor.submit(evenTask);
        System.out.println(cache);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}