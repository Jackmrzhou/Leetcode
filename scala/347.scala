import scala.collection.mutable.PriorityQueue
import scala.collection.mutable.HashMap
object Solution {
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        val count = HashMap[Int, Int]()
        for (n <- nums) {
            if (count.contains(n)) count.update(n, count(n) + 1)
            else count += (n -> 1)
        }
        case class pair(n: Int, count: Int) extends Ordered[pair] {
            def compare(that: pair): Int = that.count.compareTo(count)
        }
        val minHeap = PriorityQueue[pair]()
        for ((_k, v) <- count) {
            minHeap.enqueue(pair(_k, v))
            if (minHeap.length > k) {
                minHeap.dequeue()
            }
        }
        minHeap.map(p => p.n).toArray
    }
}