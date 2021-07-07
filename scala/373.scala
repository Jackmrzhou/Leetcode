import scala.collection.mutable.ListBuffer
import scala.collection.mutable.PriorityQueue
object Solution {
    def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
        case class pair(i: Int, j: Int) extends Ordered[pair] {
            def compare(that: pair): Int = nums1(that.i)+nums2(that.j) compare nums1(i)+nums2(j)
            def next:pair = pair(i, j+1)
        }

        val minHeap = PriorityQueue[pair]()
        for (i <- 0 until nums1.length) {
            minHeap.enqueue(pair(i, 0))
        }

        val res = ListBuffer[List[Int]]()
        while (res.length != k && minHeap.nonEmpty) {
            val p = minHeap.dequeue()
            res += List(nums1(p.i), nums2(p.j))
            val next = p.next
            if (next.j < nums2.length)
                minHeap.enqueue(p.next)
        }
        res.toList
    }
}