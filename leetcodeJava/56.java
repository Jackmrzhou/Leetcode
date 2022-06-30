package leetcodeJava;

import java.util.Arrays;
import java.util.*;;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        var res = new ArrayList<int[]>();
        for (var i = 0; i < intervals.length; i++) {
            var start = intervals[i][0];
            var end = intervals[i][1];
            for (var j = i; j < intervals.length; j++) {
                if (intervals[j][0] > end) {
                    break;
                } else {
                    end = Math.max(end, intervals[j][1]);
                }
                i = j;
            }
            res.add(new int[]{start, end});
        }
        var arr = new int[res.size()][];
        return res.toArray(arr);
    }
}