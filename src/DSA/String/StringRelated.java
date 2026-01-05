package DSA.String;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringRelated {
    public static void main(String[] args) {
        String s = "Java is the world";
        StringBuilder output = new StringBuilder();
        for(String s2 : s.split(" ")){
           StringBuilder sb = new StringBuilder(s2);
           sb.reverse();
            output.append(sb).append(" ");
        }
        System.out.println(output);
        String sb1 = Arrays.stream(s.split(" "))
                .map(word->{
                    return new StringBuilder(word).reverse();
                })
                .collect(Collectors.joining(" "));
        System.out.println(sb1);

        //bbaacccdee
        //word.chars() used in word not in sentence for this Arrays.stream(word)
        String s4 = "bbaacccdee";

        String sortedStream = s4.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                //below line will give you ascending order
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .map(String :: valueOf)
                .collect(Collectors.joining());
        System.out.println(sortedStream);
        String sortedStream1 = s4.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                //below line will give you decending order
                .sorted(Map.Entry.<Character,Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .map(String :: valueOf)
                .collect(Collectors.joining());
        System.out.println(sortedStream1);
    }
}
