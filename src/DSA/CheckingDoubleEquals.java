package DSA;

public class CheckingDoubleEquals {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println( a == b);
        //a==b is true because of CacheRange of Integer is -128 to 127
        System.out.println( c == d);

        Long e = 889898L;
        Long f = 989890L;
        System.out.println(e == f);
    }
}
