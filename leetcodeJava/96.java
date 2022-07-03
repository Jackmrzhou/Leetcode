package leetcodeJava;

class Solution {
    private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        return bst(1, n);
    }
    private int bst(int l, int r) {
        if (l == r) return 1;
        var value = cache.get(r-l);
        if (value != null) return value.intValue();
        int res = 0;
        for (var i = l; i <= r; i++) {
            int left = 0, right = 0;
            if (i != l) left = bst(l, i-1);
            if (r != i) right = bst(i+1, r);
            if (left == 0) {
                res += right;
            } else if (right == 0) {
                res += left;
            } else {
                res += left * right;
            }
        }
        cache.put(r-l, res);
        return res;
    }
}
