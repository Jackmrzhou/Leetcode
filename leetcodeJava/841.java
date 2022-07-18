package leetcodeJava;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        var res = true;
        for (var v : visited) res = res && v;
        return res;
    }
    
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (var j : rooms.get(i)) {
            dfs(rooms, visited, j);
        }
    }
}
