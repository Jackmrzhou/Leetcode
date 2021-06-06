import scala.collection.mutable.Stack
class BSTIterator(_root: TreeNode) {

    val s = {
        var ptr = _root
        val stack = Stack[TreeNode]()
        while (ptr != null) {
            stack.push(ptr)
            ptr = ptr.left
        }
        stack
    }

    def next(): Int = {
        val cur = s.pop()
        var ptr = cur.right
        while (ptr != null) {
            s.push(ptr)
            ptr = ptr.left
        }
        cur.value
    }

    def hasNext(): Boolean = {
        !s.isEmpty
    }

}