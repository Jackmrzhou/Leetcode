package leetcodeJava;

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], min = 1, max = 1;
        for (var n : nums) {
            var newMin = Math.min(Math.min(min*n, n), max*n);
            var newMax = Math.max(Math.max(max*n, n), min*n);
            min = newMin;
            max = newMax;
            res = Math.max(res, newMax);
        }
        return res;
    }
}
