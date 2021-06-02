import scala.collection.mutable.ListBuffer
import scala.collection.mutable
object Solution {
    def copyRandomList(head: Node): Node = {
        if (head == null) return null
        val l = ListBuffer[Node]()
        var ptr = head
        val map = mutable.Map[Node, Int]()
        var counter = 0
        while (ptr != null) {
            val node = new Node(ptr.value)
            if (!l.isEmpty) {
                l.last.next = node
            }
            l += node
            map.put(ptr, counter)
            ptr = ptr.next
            counter += 1
        }
        val arr = l.toArray
        ptr = head
        counter = 0
        while(ptr != null) {
            if (ptr.random != null)
                arr(counter).random = arr(map(ptr.random))
            counter += 1
            ptr = ptr.next
        }
        arr.head
    }
}