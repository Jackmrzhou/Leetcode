import scala.collection.mutable.PriorityQueue
object Solution {
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val minHeap = PriorityQueue.empty(Ordering[Int].reverse)
        nums.foreach(n => {
            minHeap.enqueue(n)
            if (minHeap.length > k) {
                minHeap.dequeue()
            }
        })
        minHeap.dequeue()
    }
}