import scala.collection.mutable.PriorityQueue
object Solution {
    def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
        val total = matrix.length*matrix.length
        var size = 0
        val heap = if (k > total / 2) {
            size = total - k + 1
            PriorityQueue.empty(Ordering[Int].reverse)
        } else {
            size = k
            PriorityQueue.empty(Ordering[Int])
        }
        matrix.foreach(p => p.foreach(n => {
            heap.enqueue(n)
            if (heap.length > size) {
                heap.dequeue()
            }
        }))
        heap.dequeue()
    }
}