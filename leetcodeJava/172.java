package leetcodeJava;

class Solution {
    public int trailingZeroes(int n) {
        int tmp = 5;
        int res = 0;
        while (tmp <= n) {
            res += n/tmp;
            tmp = tmp*5;
        }
        return res;
    }
}
