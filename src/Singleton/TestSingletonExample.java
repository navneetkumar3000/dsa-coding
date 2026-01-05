package Singleton;

public class TestSingletonExample {
    public static void main(String[] args) {
        //Singleton class is a design pattern in object-oriented programming that ensures
        //1.Only one instance of the class is created during the entire execution of the program
        //2.Global access point to that instance is provided
        //Lazy Initialization
        System.out.println("Lazy Initialization");
        SingletonExampleLazy s1 = SingletonExampleLazy.getInstance();
        System.out.println(s1.hashCode());
        SingletonExampleLazy s2 = SingletonExampleLazy.getInstance();
        System.out.println(s2.hashCode());
        SingletonExampleLazy s3 = SingletonExampleLazy.getInstance();
        System.out.println(s3.hashCode());
        SingletonExampleLazy s4 = SingletonExampleLazy.getInstance();
        System.out.println(s4.hashCode());
        SingletonExampleLazy s5 = SingletonExampleLazy.getInstance();
        System.out.println(s5.hashCode());
        System.out.println(SingletonExampleLazy.getCount());

        //Static Block Initialization
        System.out.println("Static Block Initialization");
        SingletonStaticInitialization s6 = SingletonStaticInitialization.getInstance();
        System.out.println(s6.hashCode());
        SingletonStaticInitialization s7 = SingletonStaticInitialization.getInstance();
        System.out.println(s7.hashCode());
        SingletonStaticInitialization s8 = SingletonStaticInitialization.getInstance();
        System.out.println(s8.hashCode());
        SingletonStaticInitialization s9 = SingletonStaticInitialization.getInstance();
        System.out.println(s9.hashCode());
        SingletonStaticInitialization s10 = SingletonStaticInitialization.getInstance();
        System.out.println(s10.hashCode());

        //Eager Initialization
        System.out.println("Eager Initialization");
        SingletonExampleEager s11 = SingletonExampleEager.getInstance();
        System.out.println(s11.hashCode());
        SingletonExampleEager s12 = SingletonExampleEager.getInstance();
        System.out.println(s12.hashCode());

        //Bill Pugh Initialization (Thread-Safe)
        System.out.println("Bill Pugh Initialization");
        BillPughSingleton billPughSingleton1 = BillPughSingleton.getInstance();
        System.out.println(billPughSingleton1.hashCode());
        BillPughSingleton billPughSingleton2 = BillPughSingleton.getInstance();
        System.out.println(billPughSingleton2.hashCode());

        //Enum Singleton (Thread-Safe)
        System.out.println("Enum Singleton");
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton.hashCode());
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton1.hashCode());

        //Thread-Safe Singleton
        System.out.println("Thread-Safe Singleton");
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton.hashCode());
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstance();
        System.out.println(threadSafeSingleton1.hashCode());

        //Double-Checked Thread-Safe Singleton mainly used in multi-threading concept
        System.out.println("Thread-Safe Double Checked Singleton");
        DoubleCheckedThreadSingleton doubleCheckedThreadSingleton = DoubleCheckedThreadSingleton.getInstance();
        System.out.println(doubleCheckedThreadSingleton.hashCode());
        DoubleCheckedThreadSingleton doubleCheckedThreadSingleton1 = DoubleCheckedThreadSingleton.getInstance();
        System.out.println(doubleCheckedThreadSingleton1.hashCode());
    }
}
