package leetcodeJava;

class Solution {
    public int kthGrammar(int n, int k) {
        if (k == 1) return 0;
        var x = 1;
        while (x < k) {
            x = x*2;
        }
        return 1-kthGrammar(n, k - x/2);
    }
}
