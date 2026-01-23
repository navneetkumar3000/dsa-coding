package DSA.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeparateCharacterNumber {
    public static void main(String[] args) {
        String s = "ab2jj12nn233%%%jjjj";
        List<Character> ch = s.chars()
            .distinct()
            .mapToObj(c->(char)c)
            .filter(Character::isLetter).collect(Collectors.toList());
        List<Integer> digit = s.chars()
                .distinct()
                .filter(Character::isDigit)
                .map(c1->c1-'0')
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Character : " + ch + " Digit : " + digit);

        //Using Map
        Map<String, List<?>> result = new HashMap<>();

        result.put("chars",
                s.chars().distinct()
                        .filter(Character::isLetter)
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()));

        result.put("numbers",
                s.chars().distinct()
                        .filter(Character::isDigit)
                        .map(c -> c - '0')
                        .boxed()
                        .collect(Collectors.toList()));

        System.out.println(result);

        //Collectors.partitioningBy(Character::isDigit))
        Map<Boolean, List<Character>> map =
                s.chars().distinct()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.partitioningBy(Character::isDigit));

        System.out.println("Digits: " + map.get(true));
        System.out.println("Chars : " + map.get(false));

    }
}
