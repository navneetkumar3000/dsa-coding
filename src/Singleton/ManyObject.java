package Singleton;

public class ManyObject {
    private static int count = 0;
    ManyObject() {
        System.out.println("Object creating using constructor");
        count++;
    }

    public static int getCount(){
        return count;
    }
}
