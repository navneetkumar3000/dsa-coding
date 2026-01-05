package DSA.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();
        int [] fibonacci;
        fibonacci = fibonacciSeries(number);
        System.out.println("Fibonacci Series : ");
        Arrays.stream(fibonacci).forEach(n -> System.out.print(n + " "));
        System.out.println();
        int [] fibonacci1;
        fibonacci1 = fibonacciSeriesDynamicArray(number);
        System.out.println("Fibonacci Series for iterating from index 2 : ");
        Arrays.stream(fibonacci1).forEach(n -> System.out.print(n + " "));

        //Using Stream Api
        System.out.println();
        System.out.println("Using Stream api");
        Stream.iterate(new int[]{0, 1},
                        t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(n -> System.out.print(n + " "));

        //Using Recursion
        System.out.println();
        System.out.println("Using Recursion");
        fibonacciSeriesRecursion(number);
    }

    //Using Iterative O(n)
    private static int[] fibonacciSeries(int number) {
        int [] fib = new int[number];
        int first = 0, second = 1, next;
        for(int i = 0; i < number; i++){
            fib[i] = first;
            next = first + second;
            first = second;
            second = next;
        }
        return fib;
    }

    //Using Iterative from 2nd index
    private static int[] fibonacciSeriesDynamicArray(int number) {
        int [] fib = new int[number];
        fib[0] = 0;
        fib[1] = 1;
        //Adding datas from 2nd index
        for(int i = 2; i < number; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    //Using Recursive
    private static void fibonacciSeriesRecursion(int number) {
        for(int i = 0; i < number; i++){
            System.out.print(fibonacciSeriesRecursive(i) + " ");
        }
    }
    private static int fibonacciSeriesRecursive(int index) {
        if(index <= 1){
            return index;
        }
        return fibonacciSeriesRecursive(index - 1) + fibonacciSeriesRecursive(index -2);
    }
}
