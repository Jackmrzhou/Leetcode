package leetcodeJava;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        var visited = new Node[101];
        return dfs(node, visited);
    }
    
    private Node dfs(Node node, Node[] visited) {
        if (visited[node.val] != null) {
            return visited[node.val];
        }
        var n = new Node(node.val);
        visited[n.val] = n;
        for (var neighbor : node.neighbors) {
            n.neighbors.add(dfs(neighbor, visited));
        }
        return n;
    }
}
