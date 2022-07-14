package leetcodeJava;

class Solution {
    public List<String> letterCasePermutation(String s) {
        if (s.length() == 0) {
            var l = new LinkedList();
            l.add("");
            return l;
        }
        var res = letterCasePermutation(s.substring(1, s.length()));
        var ch = s.charAt(0);
        var tmp = new LinkedList<String>();
        if (Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
            for (var str : res) {
                tmp.add(String.valueOf(Character.toUpperCase(ch)) + str);
                tmp.add(String.valueOf(Character.toLowerCase(ch)) + str);
            }
        } else {
            for (var str : res) {
                tmp.add(String.valueOf(ch) + str);
            }
        }
        return tmp;
    }
}
