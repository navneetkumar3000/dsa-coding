package Singleton;

public class SingletonExampleEager {
    //The instance is created at class loading time, even if it’s never used.
    //Simple, but may waste memory if object is heavy and unused.
    //Real World Example :Runtime in Java is a Singleton
    private static final SingletonExampleEager INSTANCE = new SingletonExampleEager();
    private SingletonExampleEager() {}
    public static SingletonExampleEager getInstance() {
        return INSTANCE;
    }
}
