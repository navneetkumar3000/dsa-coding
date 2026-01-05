package Singleton;

public enum EnumSingleton {
    //Prevents reflection, serialization, and cloning issues
    //Best for singletons where serialization matters
    //Real World Example : Global Settings Manager.
    INSTANCE;
}
