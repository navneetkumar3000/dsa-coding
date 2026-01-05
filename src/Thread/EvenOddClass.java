package Thread;

class ThreadConcept {
    private int number = 1;
    private static final int limit = 5;
    private boolean isOdd = true;

    public synchronized void oddPrint() {
        while (number <= limit) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Odd Number : " + number);
            number++;
            isOdd = false;
            notify();
        }
    }

    public synchronized void evenPrint() {
        while (number <= limit) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even Number : " + number);
            number++;
            isOdd = true;
            notify();
        }
    }
}

public class EvenOddClass {
    public static void main(String[] args) {
        //Whenever if method reference using non-static methods we need to create first object of that class & use that objectName
        // for method references
        ThreadConcept threadConcept = new ThreadConcept();
        Thread oddThread = new Thread(threadConcept::oddPrint);
        Thread evenThread = new Thread(threadConcept::evenPrint);
        oddThread.start();
        evenThread.start();
    }
}

