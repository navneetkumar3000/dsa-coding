import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Reversing the character & skip number & special symbol
        String s = "ab$c#ab$x";
        char [] charArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left<right){
            if(!Character.isLetter(charArray[left])){
                left++;
            } else if (!Character.isLetter(charArray[right])){
                right--;
            } else {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(new String(charArray));
        List<String> str = Arrays.asList("Pen","Pencil","Chair","Bench","Pen","Bench");
        Map<String, Integer> result = str.stream().collect(Collectors.groupingBy(
                Function.identity(),Collectors.collectingAndThen(Collectors.counting(),Long::intValue)
        )).entrySet().stream().filter(e->e.getValue()==1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        result.forEach((K,V)->System.out.println(K+" "+V));

    }
}