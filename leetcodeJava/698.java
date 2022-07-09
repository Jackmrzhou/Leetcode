package leetcodeJava;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        var sorted = Arrays.stream(nums).boxed()
        .sorted(Collections.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();
        int sum = 0;
        for (var n : nums) sum += n;
        if (nums[0] > sum/k || sum < k) return false;
        if (sum % k == 0) return solve(sorted, 0, k, sum/k, sum/k);
        else return false;
    }
    
    private boolean solve(int[] nums, int start, int k, int sum, int target) {
        if (k == 0) {
            return true;
        }
        if (target == 0) {
            return solve(nums, 0, k-1, sum, sum);
        }
        if (target < 0) return false;
        for (var i = start; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= target) {
                nums[i] = -nums[i];
                if (solve(nums, i+1, k, sum, target + nums[i])) return true;
                nums[i] = -nums[i];
            }
        }
        return false;
    }
}
