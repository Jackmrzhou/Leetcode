package leetcodeJava;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var arrayList = new ArrayList<List<String>>(Stream.of(strs).map(s -> {
            var arr = s.toCharArray();
            Arrays.sort(arr);
            return new String[]{String.valueOf(arr), s};
        }).sorted((x, y) -> {
            return x[0].compareTo(y[0]);
        }).collect(Collectors.groupingBy(x -> x[0], Collectors.mapping(x -> x[1], Collectors.toList()))).values());
        return arrayList;
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}