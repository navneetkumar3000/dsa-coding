package Singleton;

public class DoubleCheckedThreadSingleton {
    //Reduces synchronization cost by checking twice.
    //Uses volatile to avoid caching issues.
    private static volatile DoubleCheckedThreadSingleton INSTANCE;
    private DoubleCheckedThreadSingleton() { }
    public static DoubleCheckedThreadSingleton getInstance() {
        if (INSTANCE == null) { // First check
            synchronized (DoubleCheckedThreadSingleton.class) {
                if (INSTANCE == null) { // Second check
                    INSTANCE = new DoubleCheckedThreadSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
