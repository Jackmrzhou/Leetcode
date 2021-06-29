import scala.collection.mutable.Stack
object Solution {
    def isValidSerialization(preorder: String): Boolean = {
        if (preorder == "#") return true
        case class node(var left: node, var right: node)
        val NIL = node(null, null)
        val stack = Stack[node]()
        var isFirstTime = true
        preorder.split(",").foreach(p => {
            p match {
                case "#" => {
                    if (stack.isEmpty) return false
                    if (stack.top.left == null) stack.top.left = NIL
                    else if (stack.top.right == null) stack.top.right = NIL
                    if (stack.top.left != null && stack.top.right != null) stack.pop()
                }
                case _ => {
                    if (stack.isEmpty && isFirstTime) {
                        isFirstTime = false
                        stack.push(node(null, null))
                    } else if (stack.isEmpty) {
                        return false
                    } else {
                        val newNode = node(null, null)
                        if (stack.top.left == null) stack.top.left = newNode
                        else if (stack.top.right == null) stack.top.right = newNode
                        if (stack.top.left != null && stack.top.right != null) stack.pop()
                        stack.push(newNode)
                    }
                }
            }
        })
        stack.isEmpty
    }
}