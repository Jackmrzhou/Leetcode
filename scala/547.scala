object Solution {
    def findCircleNum(isConnected: Array[Array[Int]]): Int = {
        val res = Array.fill(isConnected.length+1)(-1)
        def find(i: Int): Int = {
            if (res(i) == -1 || res(i) == -i) {
                res(i) = -i
                i
            } else {
                val tmp = find(res(i))
                res(i) = tmp
                tmp
            }
        }
        def union(i: Int, j: Int) {
            val root1 = find(i)
            val root2 = find(j)
            if (root2 != root1) {
                res(root2) = root1
            }
        }
        for (i<-0 until isConnected.length; j<-0 until isConnected.length; if isConnected(i)(j) == 1) {
            union(i+1, j+1)
        }
        res.count(_ <= 0)-1
    }
}