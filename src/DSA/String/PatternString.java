package DSA.String;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternString {
    public static void main(String[] args) {
        String s1 = "abcabccadb";
        char[] s = "abcabccadb".toCharArray();
        Map<Character, Long> results = new String(s).chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        results.forEach((K, V) -> System.out.print(K.toString() + V));
        //output a3b3c3d1
        Arrays.sort(s);
        Map<Character, Long> results1 = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        results1.forEach((K, V) -> System.out.print(K+""+V));
    }
}
