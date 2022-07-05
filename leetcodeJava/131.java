package leetcodeJava;

class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return List.of(new LinkedList<String>());
        var res = new LinkedList<List<String>>();
        for (var i = 1; i <= s.length(); i++) {
            if (test(s.substring(0, i))) {
                var partitions = partition(s.substring(i, s.length()));
                for (var p : partitions) {
                    p.add(0, s.substring(0, i));
                    res.add(p);
                }
            }
        }
        return res;
    }
    
    private boolean test(String s) {
        for (var i = 0; i <= s.length()/2; i++) 
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }
}
