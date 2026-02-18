package Thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;



public class FourThreadWithCache {
    public static void main(String[] args) throws InterruptedException {

        NumberPrinter1 printer = new NumberPrinter1();

        Thread odd1 = new Thread(printer::printOdd, "Odd-1");
        Thread odd2 = new Thread(printer::printOdd, "Odd-2");
        Thread even1 = new Thread(printer::printEven, "Even-1");
        Thread even2 = new Thread(printer::printEven, "Even-2");

        odd1.start();
        odd2.start();
        even1.start();
        even2.start();

        odd1.join();
        odd2.join();
        even1.join();
        even2.join();

        printer.printCache();
    }
}

class NumberPrinter1 {

    private int number = 1;
    private final int LIMIT = 30;

    private final Map<Integer, String> cache = new ConcurrentHashMap<>();

    public synchronized void printOdd() {
        while (true) {
            // Exit condition check FIRST
            if (number > LIMIT) {
                notifyAll();   // wake remaining threads
                return;
            }
            // Wait if number is even
            while (number % 2 == 0) {
                try {
                    wait();
                    // Re-check limit after waking up
                    if (number > LIMIT) {
                        notifyAll();
                        return;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // Final safety check
            if (number <= LIMIT) {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                cache.put(number, Thread.currentThread().getName());
                number++;
                notifyAll();
            }
        }
    }

    public synchronized void printEven() {
        while (true) {
            // Exit condition check FIRST
            if (number > LIMIT) {
                notifyAll();
                return;
            }
            // Wait if number is odd
            while (number % 2 != 0) {
                try {
                    wait();
                    if (number > LIMIT) {
                        notifyAll();
                        return;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (number <= LIMIT) {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                cache.put(number, Thread.currentThread().getName());
                number++;
                notifyAll();
            }
        }
    }

    public void printCache() {
        System.out.println("\n===== CACHE CONTENT =====");
        cache.forEach((k, v) ->
                System.out.println("Number: " + k + " printed by: " + v));
    }
}