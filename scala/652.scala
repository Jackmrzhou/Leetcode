import scala.collection.mutable
object Solution {
    def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
        val map = mutable.Map[String, List[TreeNode]]()
        def marshal(root: TreeNode): String = {
            if (root == null) " "
            else {
                val s =root.value.toString+" " + marshal(root.left)+" " + marshal(root.right)
                if (map.contains(s)) map(s) = map(s) :+ root
                else map += (s -> List(root))
                s
            }
        }
        
        marshal(root)
        map.flatMap{
            case (k,v) => if (v.length > 1) List(v.head) else Nil
        }.toList
    }
}