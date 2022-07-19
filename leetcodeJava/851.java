package leetcodeJava;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] g = new int[n][n];
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (var arr : g) Arrays.fill(arr, -1);
        for (int i = 0; i < richer.length; i++) {
            g[richer[i][1]][richer[i][0]] = 1;
        }
        for (int i = 0; i < n; i++) dfs(visited, quiet, g, i);
        return visited;
    }
    
    private int dfs(int[] visited, int[] quiet, int[][] g, int i) {
        if (visited[i] != -1) return visited[i];
        var res = i;
        for (int j = 0; j < g.length; j++) {
            if (g[i][j] != -1) {
                var person = dfs(visited, quiet, g, j);
                if (quiet[person] < quiet[res]) {
                    res = person;
                }
            }
        }
        visited[i] = res;
        return res;
    }
}

