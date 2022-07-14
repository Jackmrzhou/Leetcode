package leetcodeJava;

class Solution {
    public boolean isBipartite(int[][] graph) {
        var color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;
            if (!dfs(color, graph, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[] colors, int[][] graph, int i, int color) {
      if (colors[i] != 0 && colors[i] != color) return false;
      if (colors[i] != 0) return true;
      colors[i] = color;
      var arr = graph[i];
      if (arr == null) return true;
      for (int j = 0; j < arr.length; j++) {
          if (!dfs(colors, graph, arr[j], -color)) {
              return false;
          }
      }
      return true;
   }
}
