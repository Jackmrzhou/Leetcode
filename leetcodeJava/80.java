package leetcodeJava;

class Solution {
    public int removeDuplicates(int[] nums) {
        var l = 0; 
        for (var i = 0; i < nums.length; i++) {
            var count = 0;
            for (var j = i; j <= nums.length; j++) {
                if (j < nums.length && nums[j] == nums[i]) {
                    count++;
                } else {
                    i = j-1;
                    break;
                }
                if (count <= 2) {
                    nums[l] = nums[i];
                    l++;
                }
            }
        }
        return l;
    }
}