package leetcodeJava;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var res = 0;
        for (var i = 0; i < grid.length; i++) 
            for (var j = 0; j < grid[0].length; j++)
                res = Math.max(res, dfs(grid, i, j));
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + dfs(grid, i+1, j) + dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i, j-1);
    }
}
