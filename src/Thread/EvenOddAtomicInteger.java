package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddAtomicInteger {
    private static final AtomicInteger num = new AtomicInteger(1);
    private static final int LIMIT = 20;

    public static void main(String[] args) {
        //Odd Thread
        Thread odd = new Thread( () -> {
            while (num.get() <= LIMIT) {
                int n = num.get();
                if(n % 2 == 1) {
                    System.out.println("ODD : " + n);
                    num.incrementAndGet();
                }
            }
        });

        //Even Thread
        Thread even = new Thread( () -> {
            while (num.get() <= LIMIT) {
                int n = num.get();
                if(n % 2 == 0) {
                    System.out.println("EVEN : " + n);
                    num.incrementAndGet();
                }
            }
        });

        odd.start();
        even.start();
    }
}
