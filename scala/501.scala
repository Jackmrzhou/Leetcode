object Solution {
    def findMode(root: TreeNode): Array[Int] = {
        val res = scala.collection.mutable.ListBuffer[Int]()
        var lastCount = -1
        var cur = -100001
        var count = 0
        def f(root: TreeNode) {
            if (root == null) return
            f(root.left)
            if (cur == root.value) {
                count += 1
            } else {
                if (cur == -100001) {
                    count += 1
                } else if (res.isEmpty || count > lastCount) {
                    res.clear()
                    res += cur
                    lastCount = count
                    count = 1
                } else if (count == lastCount) {
                    res += cur
                    count = 1
                } else {
                    count = 1
                }
                cur = root.value
            }
            f(root.right)
        }
        f(root)
        if (count > lastCount) {
            res.clear()
            res += cur
        } else if (count == lastCount) {
            res += cur
        }
        res.toArray
    }
}