object Solution {
    def maxDepth(root: Node): Int = {
        if (root == null) return 0
        var d = 0
        for (node <- root.children) {
            d = d.max(maxDepth(node))
        }
        d+1
    }
}