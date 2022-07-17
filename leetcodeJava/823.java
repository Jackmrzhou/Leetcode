class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + solve(arr, arr[i])) % m;
        }
        return (int)res;
    }
    
    private Map<Long, Long> cache = new HashMap();
    private final int m = 1000000007;
    
    private long solve(int[] arr, int k) {
        if (k == 1) return 0;
        var total = cache.get(Long.valueOf(k));
        if (total != null) return total.intValue();
        long res = 0;
        var flag = false;
        for (int i = 0; i < arr.length && arr[i] <= k; i++) {
            if (k == arr[i]) {
                res++;
                flag = true;
                break;
            }
            if (k % arr[i] == 0) {
                res = (res + solve(arr, arr[i]) * solve(arr, k/arr[i])) % m;
            }
        }
        if (!flag) res = 0;
        cache.put(Long.valueOf(k), Long.valueOf(res));
        return res;
    }
}