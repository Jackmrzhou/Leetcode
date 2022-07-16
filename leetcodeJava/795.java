package leetcodeJava;

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int sum1 = 0, count1 = 0, sum2 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left) {
                count1++;
                sum1 += count1;
            } else {
                count1 = 0;
            }
            if (nums[i] <= right) {
                count2++;
                sum2 += count2;
            } else {
                count2 = 0;
            }
        }
        return sum2 - sum1;
    }
}
