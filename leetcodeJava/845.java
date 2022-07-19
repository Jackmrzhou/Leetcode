package leetcodeJava;

class Solution {
    public int longestMountain(int[] arr) {
        int l = 0;
        var res = 0;
        while (l < arr.length) {
            int i = l+1;
            while(i < arr.length && arr[i] > arr[i-1]) i++;
            if (i == l+1) {
                l = i;
                continue;
            }
            int j = i;
            while(j < arr.length && arr[j] < arr[j-1]) j++;
            if (j-l >= 3 && j != i) res = Math.max(res, j-l);
            l = j-1;
        }
        return res;
    }
}
