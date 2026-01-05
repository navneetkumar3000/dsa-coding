package DSA.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SwapNumberWithoutThirdVariable {
    public static void main(String[] args) {
        System.out.println("Enter two number");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Before swap a = " + a + " and b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swap a = " + a + " and b = " + b);

        //Using XOR operator
        System.out.println("Using XOR operator");
        System.out.println("Enter two number");
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println("Before swap c = " + c + " and d = " + d);
        c = c ^ d;
        d = c ^ d;
        c = c ^ d;
        System.out.println("After swap c = " + c + " and d = " + d);

        //Using Collections.swap()
        Integer e = 10, f = 20;
        System.out.println("Using Collections.swap");
        System.out.println("Before swap e = " + e + " and f = " + f);
        List<Integer> list = Arrays.asList(e, f);
        Collections.swap(list, 0, 1);
        e = list.get(0);
        f = list.get(1);
        System.out.println("After swap e = " + e + " and f = " + f);

        //Using IntStream.of(b,a).toArray
        int g = 10, h = 20;
        System.out.println("Using IntStream.of(b,a).toArray");
        System.out.println("Before swap g = " + g + " and h = " + h);
        int[] swapped = IntStream.of(h, g).toArray();
        Collections.swap(list, 0, 1);
        g = swapped[0];
        h = swapped[1];
        System.out.println("After swap g = " + g + " and h = " + h);
    }
}
