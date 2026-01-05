package Singleton;

public class ThreadSafeSingleton {
    //Slower due to synchronization overhead
    //ensure only one thread creates the instance
    //Real World Example : A Logger that must be accessed safely in multithreaded applications.
    private static final ThreadSafeSingleton SAFE_SINGLETON = new ThreadSafeSingleton();
    private ThreadSafeSingleton() { }
    public static synchronized ThreadSafeSingleton getInstance(){
        return SAFE_SINGLETON;
    }
}
