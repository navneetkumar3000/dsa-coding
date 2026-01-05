package Singleton;

public class CallingManyObjectTest {
    public static void main(String[] args) {
        ManyObject a1 = new ManyObject();
        ManyObject a2 = new ManyObject();
        ManyObject a3 = new ManyObject();
        ManyObject a4 = new ManyObject();
        ManyObject a5 = new ManyObject();
        System.out.println(ManyObject.getCount());
    }
}
