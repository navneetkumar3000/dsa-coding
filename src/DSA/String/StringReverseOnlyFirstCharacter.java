package DSA.String;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringReverseOnlyFirstCharacter {
    public static void main(String[] args) {
        String [] s= "my name is shivaraj".split(" ");
        String s2 = "";
        for(String s1:s){
           if(!s1.isEmpty()){
               s2 += Character.toUpperCase(s1.charAt(0)) + s1.substring(1) + " ";
           }
        }
        String s3 = s2.trim();
        System.out.print(s2.trim() + " : " + s2.length() );
        System.out.println(s3.length());
        //Using Java 8
        String result = Arrays.stream(s)
                .map(words -> words.isEmpty() ? words : Character.toUpperCase(words.charAt(0))+words.substring(1))
                .collect(Collectors.joining(" "));
        result.chars()
        .mapToObj(ch -> (char) ch)
        .forEach(System.out::print);
    }
}
