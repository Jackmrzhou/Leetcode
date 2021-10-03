object Solution {
    def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
        val arr = Array.fill(edges.length+1)(-1)
        def find(i: Int): Int = {
            if (arr(i) == -1) i
            else find(arr(i))
        }
        def union(i: Int, j: Int) = {
            val x = find(i)
            val y = find(j)
            arr(y) = x
        }

        for (e <- edges) {
            if (find(e.head) == find(e.last)) return e
            union(e.head, e.last)
        }
        null
    }
}