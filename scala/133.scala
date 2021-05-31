object Solution {
    def cloneGraph(graph: Node): Node = {
        val nodes = Array.ofDim[Node](101)
        def dfs(g: Node): Node = {
          if (nodes(g.value-1)==null) {
            nodes(g.value-1) = new Node(g.value)
            nodes(g.value-1)
          } else return nodes(g.value-1)
          nodes(g.value-1).neighbors = g.neighbors.map(n => dfs(n)).toList
          nodes(g.value-1)
        }
        if (graph == null) return null
        dfs(graph)
        nodes.head
    }
}