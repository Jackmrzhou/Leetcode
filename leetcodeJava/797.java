package leetcodeJava;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0, graph.length-1);
    }
    
    private List<List<Integer>> dfs(int[][] g, int i, int j) {
        if (i == j) {
            var l = new LinkedList<Integer>();
            l.add(Integer.valueOf(i));
            return List.of(l);
        }
        var res = new LinkedList<List<Integer>>();
        for (int k = 0; k < g[i].length; k++) {
            var tmp = dfs(g, g[i][k], j);
            if (tmp != null && tmp.size() != 0) {
                for (var l: tmp) {
                    l.add(0, Integer.valueOf(i));
                    res.add(l);
                }
            }
        }
        return res;
    }
}
