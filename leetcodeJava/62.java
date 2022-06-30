package leetcodeJava;

class Solution {
    public int uniquePaths(int m, int n) {
        var map = new int[m][n];
        for (var i = 0; i < m; i++)
            for (var j = 0; j < n; j++) {
                if (i == 0 || j == 0) map[i][j] = 1;
                else map[i][j] = map[i][j-1] + map[i-1][j];
            }
        return map[m-1][n-1];
    }
}
