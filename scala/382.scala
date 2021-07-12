import scala.collection.mutable.ArrayBuffer
import scala.util.Random
class Solution(_head: ListNode) {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    val cache = {
        val arr = ArrayBuffer[ListNode]()
        var ptr = _head
        while (ptr != null) {
            arr += ptr
            ptr = ptr.next
        }
        arr
    }

    /** Returns a random node's value. */
    def getRandom(): Int = {
        cache(Random.nextInt(cache.length)).x
    }

}