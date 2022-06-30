package leetcodeJava;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        var map = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        map[0][0] = 1;
        for (var i = 0; i < m; i++)
            for (var j = 0; j < n; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1) map[i][j] = 0;
                    else if (j > 0) map[i][j] = map[i][j-1];
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 1) map[i][j] = 0;
                    else if (i > 0) map[i][j] = map[i-1][j];
                }
                else if (obstacleGrid[i][j] == 1) map[i][j] = 0;
                else map[i][j] = map[i][j-1] + map[i-1][j];
            }
        if (obstacleGrid[m-1][n-1] == 1) return 0;
        return map[m-1][n-1];
    }
}
