package leetcodeJava;

class Solution {
    private Map<String, Integer> cache = new HashMap<String, Integer>();
    public int numDecodings(String s) {
        if (s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        var value = cache.get(s);
        if (value != null) {
            return value.intValue();
        }
        int res = 0;
        if (Integer.valueOf(s.substring(0, 2)) <= 26) {
            res = numDecodings(s.substring(1, s.length())) + numDecodings(s.substring(2, s.length()));
        } else {
            res = numDecodings(s.substring(1, s.length()));
        }
        cache.put(s, res);
        return res;
    }
}
