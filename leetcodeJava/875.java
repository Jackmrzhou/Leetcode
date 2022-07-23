package leetcodeJava;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var max = 0;
        for (var p : piles) max = Math.max(max, p);
        int l = 1, r = max;
        while (l < r) {
            int mid = (r-l)/2 + l;
            int total = 0;
            for (var p : piles) {
                total += p / mid;
                if (p % mid != 0) total++;
            }
            if (total > h) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
