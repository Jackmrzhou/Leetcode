package leetcodeJava;

class Solution {
    public String reverseWords(String s) {
        var arr = s.split(" ");
        var l = Arrays.stream(arr).filter(x -> x.length() != 0).collect(Collectors.toList());
        Collections.reverse(l);
        return String.join(" ", l);
    }
}
