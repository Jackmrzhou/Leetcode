package leetcodeJava;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 0)
                        grid[i][j] += grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
