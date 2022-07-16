package leetcodeJava;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                var s = skyline(grid, i, j);
                res += Math.max(0, s - grid[i][j]);
            }
        }
        return res;
    }
    
    private int skyline(int[][] g, int i, int j) {
        int max1=0, max2=0;
        for (int k = 0; k < g.length; k++) {
            max1 = Math.max(g[i][k], max1);
        }
        for (int k = 0; k < g.length; k++) {
            max2 = Math.max(g[k][j], max2);
        }
        return Math.min(max1, max2);
    }
}
