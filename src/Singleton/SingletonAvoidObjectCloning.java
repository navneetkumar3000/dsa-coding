package Singleton;

public class SingletonAvoidObjectCloning implements Cloneable{
    private static final SingletonAvoidObjectCloning INSTANCE = new SingletonAvoidObjectCloning();
    private SingletonAvoidObjectCloning() {}

    private static SingletonAvoidObjectCloning getInstance(){
        return INSTANCE;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not allowed for Singleton");
    }
}
