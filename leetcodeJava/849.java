package leetcodeJava;

class Solution {
    public int maxDistToClosest(int[] seats) {
        var leftMost = new int[seats.length];
        var last = -1;
        var max = 20001;
        for (int i = 0; i < leftMost.length; i++) {
            if (seats[i] == 1) last = i;
            if (last == -1) {
                leftMost[i] = max;
            } else {
                leftMost[i] = i-last;
            }
        }
        
        last = -1;
        int res = 0;
        for (int i = leftMost.length-1; i >= 0; i--) {
            if (seats[i] == 1) last = i;
            if (last == -1) {
                res = Math.max(res, Math.min(leftMost[i], max));
            } else {
                res = Math.max(res, Math.min(leftMost[i], last - i));
            }
        }
        return res;
    }
}
