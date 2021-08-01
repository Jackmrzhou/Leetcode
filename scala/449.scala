import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
class Codec {
    // Encodes a list of strings to a single string.
    def serialize(root: TreeNode): String = {
        if (root == null) ""
        else {
            val q = Queue[TreeNode]()
            val res = ListBuffer[String]()
            q.enqueue(root)
            while (!q.isEmpty) {
                val node = q.dequeue()
                if (node == null) res += "n"
                else {
                    res += node.value.toString
                    q.enqueue(node.left)
                    q.enqueue(node.right)
                }
            }
            res.mkString(",")
        }
    }
    
    // Decodes a single string to a list of strings.
    def deserialize(data: String): TreeNode = {
        if (data.isEmpty()) null
        else {
            val nodes = data.split(",").map{
                case "n" => null
                case v => new TreeNode(v.toInt)
            }.toList
            val level = Queue[TreeNode](nodes.head)
            val iter = nodes.iterator
            iter.next()
            while (level.nonEmpty) {
                val len = level.length
                for (i <- 0 until len) {
                    val l = iter.next()
                    val r = iter.next()
                    val n = level.dequeue()
                    n.left = l
                    n.right = r
                    if (l != null)
                        level.enqueue(l)
                    if (r != null)
                        level.enqueue(r)
                }
            }
            nodes.head
        }
    }
}