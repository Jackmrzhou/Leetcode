package leetcodeJava;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        var res = new LinkedList<Integer>();
        var visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(visited, graph, i)) {
                res.add(Integer.valueOf(i));
            }
        }
        return res;
    }
    
    private boolean dfs(int[] visited, int[][] g, int i) {
        if (visited[i] != 0) {
            return visited[i] == 1;
        }
        visited[i] = -1;
        var all = true;
        for (int j = 0; j < g[i].length; j++) {
            all = all && dfs(visited, g, g[i][j]);
        }
        if (all) visited[i] = 1;
        return all;
    }
}
