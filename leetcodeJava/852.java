package leetcodeJava;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while ( l < r ) {
            int mid = (r-l) / 2 + l;
            if (arr[mid+1] > arr[mid]) l = mid+1;
            else r = mid;
        }
        return l;
    }
}
