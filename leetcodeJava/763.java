package leetcodeJava;

class Solution {
    public List<Integer> partitionLabels(String s) {
        var res = new ArrayList<Integer>();
        for (var i = 0; i < s.length(); i++) {
            var end = i;
            for (var j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) end = j;
            }
            for (var j = i+1; j < end; j++) {
                for (var k = end; k < s.length(); k++) {
                    if (s.charAt(j) == s.charAt(k)) {
                        end = k;
                    }
                }
            }
            res.add(Integer.valueOf(end-i+1));
            i = end;
        }
        return res;
    }
}
