import scala.collection.immutable.TreeMap
object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
        def walk(m: TreeMap[Int, Int], level: Int, root: TreeNode): TreeMap[Int, Int] = {
          if (root == null) return m
          if (!m.contains(level)) {
            val _m = walk(m + (level -> root.value), level + 1, root.right)
            return walk(_m, level + 1, root.left)
          } else {
            return walk(walk(m, level + 1, root.right), level + 1, root.left)
          }
        }
        walk(TreeMap[Int, Int](), 0, root).values.toList
    }
}
