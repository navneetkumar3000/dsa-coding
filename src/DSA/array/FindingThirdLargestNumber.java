package DSA.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindingThirdLargestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,16,78,78,24);
        Optional<Integer> thirdLargest = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();
        thirdLargest.ifPresent(System.out::println);
    }
}
