package Thread;

public class FourThreadPrintOddEven {
    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter();

        Thread odd1 = new Thread(printer::printOdd, "Odd-1");
        Thread odd2 = new Thread(printer::printOdd, "Odd-2");

        Thread even1 = new Thread(printer::printEven, "Even-1");
        Thread even2 = new Thread(printer::printEven, "Even-2");

        odd1.start();
        odd2.start();
        even1.start();
        even2.start();
    }
}

class NumberPrinter {

    private int number = 1;
    private final int LIMIT = 30;

    public synchronized void printOdd() {
        /**     while (number <= LIMIT) { if we use like this below problems
         Suppose an Odd thread prints 29
         An Even thread prints 30
         number becomes 31
         Some threads are still inside wait()
         Now:
         number > LIMIT
         No one will call notifyAll() again
         Waiting threads stay blocked forever
         JVM does NOT exit because threads are alive
         */
        while (true) {
            while (number % 2 == 0) {
                if (number > LIMIT) {
                    notifyAll();
                    return;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (number > LIMIT) {
                notifyAll();
                return;
            }

            System.out.println(Thread.currentThread().getName() + " -> " + number);
            number++;
            notifyAll();
        }
    }

    public synchronized void printEven() {
        while (true) {
            while (number % 2 != 0) {
                if (number > LIMIT) {
                    notifyAll();
                    return;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (number > LIMIT) {
                notifyAll();
                return;
            }

            System.out.println(Thread.currentThread().getName() + " -> " + number);
            number++;
            notifyAll();
        }
    }
}