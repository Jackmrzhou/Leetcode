package leetcodeJava;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        int[] digits = new int[chs.length];
        for (var i = 0; i < chs.length; i++) {
            digits[i] = chs[i] - '0';
        }
        var res = Arrays.stream(solve(0, digits[0], digits, 0, false)).mapToObj(String::valueOf).collect(Collectors.joining(""));
        return Integer.valueOf(res).intValue();
    }
    
    private int[] solve(int min, int max, int[] digits, int i, boolean noMax) {
        if (min > max) return null;
        if (i >= digits.length) return new int[digits.length];
        for (int d = max; d >= min; d--) {
            int[] tmp = null;
            if (noMax || d < digits[i]) {
                tmp = solve(d, 9, digits, i+1, true);
            } else {
                var nextMax = 9;
                if (i+1 < digits.length) nextMax = digits[i+1];
                tmp = solve(d, nextMax, digits, i+1, noMax);
            }
            if (tmp != null) {
                tmp[i] = d;
                return tmp;
            }
        }
        return null;
    }
}
