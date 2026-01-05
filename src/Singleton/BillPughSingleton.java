package Singleton;

public class BillPughSingleton {
    //Uses static inner class
    //Thread-safe, lazy, doesn't use synchronization overhead
    //Real World Example : Connection Pool Manager — loads only when needed.
    private BillPughSingleton() {
    }
    private static class BillPughSingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonHelper.INSTANCE;
    }
}
