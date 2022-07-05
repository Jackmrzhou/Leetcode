package leetcodeJava;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        var dp = new int[triangle.size()][2];
        var last = 0;
        for (var i = 0; i < triangle.size(); i++) {
            for (var j = 0; j <= i; j++) {
                if (i == 0) dp[j][1-last] = triangle.get(i).get(j);
                else {
                    if (j == 0) {
                        dp[j][1-last] = dp[j][last] + triangle.get(i).get(j);
                    } else if (j==i) {
                        dp[j][1-last] = dp[j-1][last] + triangle.get(i).get(j);
                    } else {
                        dp[j][1-last] = Math.min(dp[j-1][last], dp[j][last]) + triangle.get(i).get(j);
                    }
                }
            }
            last = 1-last;
        }
        var res = 10001;
        for (var i = 0; i < dp.length; i++) {
            if (dp[i][last] < res) res = dp[i][last];
        }
        return res;
    }
}
