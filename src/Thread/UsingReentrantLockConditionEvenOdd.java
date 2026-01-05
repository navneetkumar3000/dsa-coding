package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UsingReentrantLockConditionEvenOdd {
    private static int num = 1;
    private static final int LIMIT = 20;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //Odd Thread
        Thread odd = new Thread( () -> {
            lock.lock();
                try {
                    while (num <= LIMIT) {
                        if (num % 2 == 1) {
                            System.out.println("ODD : " + num++);
                            condition.signal();
                        } else {
                            condition.await();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getClass());
                } finally {
                    lock.unlock();
                }
        });
        //Even Thread
        Thread even = new Thread( () -> {
            lock.lock();
                try {
                    while (num <= LIMIT) {
                        if (num % 2 == 0) {
                            System.out.println("EVEN : " + num++);
                            condition.signal();
                        } else {
                            condition.await();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getClass());
                } finally {
                    lock.unlock();
                }
        });

        odd.start();
        even.start();
    }
}
