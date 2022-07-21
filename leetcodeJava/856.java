package leetcodeJava;

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            if (count <= m/2) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1-grid[i][j];
                }
            }
        }
        
        var res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += grid[i][j] * (1<<(n-j-1));
            }
        }
        return res;
    }
}
