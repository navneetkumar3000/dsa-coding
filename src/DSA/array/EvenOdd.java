package DSA.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();
        //Below logic is for single number
        System.out.println("Without using inBuilt() methods:");
        if (number % 2 == 0) {
            System.out.println("The number is : " + number + " even.");
        } else {
            System.out.println("The number is : " + number + " odd.");
        }
        //Initializing the array of Integer
        System.out.println("Enter the size");
        int sizeArray = scanner.nextInt();
        int[] arr = new int[sizeArray];
        System.out.println("Enter the array of integer");
        for (int i = 0; i < sizeArray; i++) {
            arr[i] = scanner.nextInt();
        }
        //Logic to find even & odd using bitwise operator
        System.out.println("Using Bitwise operator:");
        for (int i = 0; i < sizeArray; i++) {
            if ((arr[i] & 1) == 0) {
                System.out.println("The number is : " + arr[i] + " even.");
            } else {
                System.out.println("The number is : " + arr[i] + " odd.");
            }
        }
        //Logic to find even & odd using Math.floorMod in java api it is good for negative integer as well
        System.out.println("Using Math.floorMod() method:");
        for (int i = 0; i < sizeArray; i++) {
            if (Math.floorMod(arr[i], 2) == 0) {
                System.out.println("The number is : " + arr[i] + " even.");
            } else {
                System.out.println("The number is : " + arr[i] + " odd.");
            }
        }
        //Using java 8 stream api
        System.out.println("Using Stream api:");
        List<Integer> evenNumber = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .boxed()// if we not use boxed conversion problems get like int --> Integer
                //int[] → IntStream → box to Integer
                .collect(Collectors.toList());
        evenNumber.forEach(n -> System.out.println("Even Number : " + n));
        List<Integer> oddNumber = Arrays.stream(arr)
                .filter(n -> n % 2 != 0)
                .boxed()// if we not use boxed conversion problems get like int --> Integer
                .collect(Collectors.toList());
        oddNumber.forEach(n -> System.out.println("Odd Number : " + n));


        //If you want to get inBetween even & odd
        System.out.println("Using IntStream for inBetween range:");
        IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Above will print even number from 1 to 10

        //Single line even or odd
        System.out.println("Using Single Line:");
        Arrays.stream(arr).forEach(n -> System.out.println(n + (n % 2 == 0 ? " Even" : " Odd")));
    }
}
