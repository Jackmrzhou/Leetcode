class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var adj = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            adj[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        var prices = new int[n][n+1];
        for (var arr : prices) Arrays.fill(arr, Integer.MAX_VALUE);
        dfs(adj, src, k+1, prices, 0);
        var res = Integer.MAX_VALUE;
        for (int i = 0; i < k+1; i++) {
            if (prices[dst][i] < res) res = prices[dst][i];
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
    
    private void dfs(int[][] adj, int cur, int k, int[][] prices, int cost) {
        if (k < 0) return;
        if (prices[cur][k] > cost) {
            prices[cur][k] = cost;
        } else {
            return;
        }
        
        for (int i = 0; i < adj.length; i++) {
            if (adj[cur][i] != 0) {
                dfs(adj, i, k-1, prices, cost+adj[cur][i]);
            }
        }
    }
}