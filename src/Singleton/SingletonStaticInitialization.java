package Singleton;

public class SingletonStaticInitialization {
    //Before class loading it creates the instance
    private static final SingletonStaticInitialization INSTANCE;
    private SingletonStaticInitialization() {
    }
    static {
        try {
            INSTANCE = new SingletonStaticInitialization();
        } catch (Exception e) {
           throw new ClassCastException();
        }
    }

    public static SingletonStaticInitialization getInstance() {
        return INSTANCE;
    }
}
