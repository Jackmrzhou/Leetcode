package leetcodeJava;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return comb(1, n, k);
    }
    
    private List<List<Integer>> comb(int start, int n, int k) {
        if (k == 0) return List.of(new LinkedList<Integer>());
        var res = new LinkedList<List<Integer>>();
        for (var i = start; i <= n-k+1; i++) {
            var c = comb(i+1, n, k-1);
            if (c != null) {
                for (var l : c) {
                    l.add(0, i);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
