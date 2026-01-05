package Singleton;

public class SingletonExampleLazy {
    //Creates instance when needed
    //Real World Example :A ConfigurationManager that loads settings only when first requested
    private static SingletonExampleLazy INSTANCE;
    private static int count = 0;
    private SingletonExampleLazy(){
        System.out.println("Singleton Object");
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static SingletonExampleLazy getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonExampleLazy();
        }
        return INSTANCE;
    }
}
