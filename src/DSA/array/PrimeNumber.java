package DSA.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        //Without using inBuilt method
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean prime = isPrime(number);
        if(prime) {
            System.out.println(number + " is Prime");
        } else {
            System.out.println(number + " is not Prime");
        }
        //For array of Integer methods
        System.out.println("For array of integer");
        System.out.println("Enter the Size");
        int n = scanner.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the array Datas");
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for (int num : arr) {
            System.out.println(isPrime(num) ? num + " is Prime" : num + " is not Prime");
        }
        //Using Stream api only prime
        System.out.println("Using Stream api");
        Arrays.stream(arr)
                .filter(PrimeNumber::isPrimeStream)
                .forEach(primes -> System.out.println(primes + " is Prime"));

        //Using partitionBy method in collect using Map
        System.out.println("Using partitionBy method in collect using Map");
        Map<Boolean, List<Integer>> result =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.partitioningBy(PrimeNumber::isPrimeStream));

        System.out.println("Prime: " + result.get(true));
        System.out.println("Not Prime: " + result.get(false));


    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //Using Stream api
    private static boolean isPrimeStream(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }
}
