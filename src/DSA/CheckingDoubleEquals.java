package DSA;

import java.util.ArrayList;

public class CheckingDoubleEquals {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println( a == b);
        //a==b is true because of CacheRange is -128 to 127, it is for number is short or within
        // range -128 to 127
        System.out.println( c == d);

        Long e = 889898L;
        Long f = 989890L;
        System.out.println(e == f);

        int g = 123;
        int h = 123;
        System.out.println(g == h);

        ArrayList <Number> array =new ArrayList<>();
        array.add(10);
        System.out.println(array);

    }
}
