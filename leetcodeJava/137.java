package leetcodeJava;

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            var count = 0;
            for (var j = i; j <= nums.length; j++) {
                if (j < nums.length && nums[j] == nums[i]) count++;
                else {
                    if (count == 1) return nums[i];
                    i = j-1;
                    break;
                }
            }
        }
        return -1;
    }
}
