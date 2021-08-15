import scala.collection.mutable
object Solution {
    def findFrequentTreeSum(root: TreeNode): Array[Int] = {
        val mem = mutable.Map[TreeNode, Int]()
        def dfs(root: TreeNode): Int = {
            if (root == null) 0
            else if (mem.contains(root)) mem(root)
            else {
                val sum = root.value + dfs(root.left) + dfs(root.right)
                mem += (root -> sum)
                sum
            }
        }
        dfs(root)
        val g = mem.toArray.groupBy(_._2)
        val max = g.maxBy(_._2.length)._2.length
        g.filter(p => p._2.length == max).map(_._1).toArray
    }
}