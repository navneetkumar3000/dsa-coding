package DSA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramProblem {
    public static void main(String[] args) {
        String[] s = {"cat","rat","bat","tea","ate"};
        Map<String, List<String>>  grouped = Arrays.stream(s)
                .collect(Collectors.groupingBy(s1->{
                    char[] ch = s1.toCharArray();
                    Arrays.sort(ch);
                    return new String(ch);
                }));
        int group = 1;
        for(List<String> groups : grouped.values()){
            System.out.println("Group :" + group + String.join(",", groups));
        }
        System.out.println(grouped.values());
        //Without using Stream
        String[] s2 = {"rat","mat","mast","bat","tar"};
        Map<String,List<String>> maps = new LinkedHashMap<>();
        for(String s3 : s2){
            char[] ch = s3.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
//            if(!maps.containsKey(key)){
//                maps.put(key, new ArrayList<>());
//            }
//            maps.get(key).add(s3);
//            Above 4 lines will be replaced by below line
            maps.computeIfAbsent(key, k -> new ArrayList<>()).add(s3);
        }
        System.out.println(maps.values());

    }
}
