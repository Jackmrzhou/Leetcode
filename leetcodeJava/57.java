package leetcodeJava;

import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var intervalList = new ArrayList<int[]>(Arrays.asList(intervals));
        int i;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0]) {
                break;
            }
        }
        intervalList.add(i, newInterval);
        int start = intervalList.get(i)[0], end = intervalList.get(i)[1], j = i;
        if (i > 0 && newInterval[0] <= intervalList.get(i-1)[1]) {
            start = Math.min(start, intervalList.get(i-1)[0]);
            i--;
        }
        for (j = i; j < intervalList.size(); j++) {
            if (intervalList.get(j)[0] <= newInterval[1]) {
                end = Math.max(end, intervalList.get(j)[1]);
            } else {
                break;
            }
        }
        var flag = false;
        var res = new LinkedList<int[]>();
        for (var k = 0; k < intervalList.size(); k++) {
            if (k < i || k >= j) {
                res.add(intervalList.get(k));
            } else if (!flag) {
                res.add(new int[]{start, end});
                flag = true;
            }
        }
        return res.toArray(new int[0][]);
    }
}