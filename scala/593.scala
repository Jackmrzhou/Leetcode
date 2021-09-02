import scala.collection.mutable
object Solution {
    def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
        val set = mutable.Set[Int]()
        if (Array(p1, p2, p3, p4).combinations(2).exists(p=>p.head.sameElements(p.last))) {
            false
        } else {
            def dis(x: Array[Int], y: Array[Int]): Int = {
                (x.head-y.head)*(x.head-y.head) + (x.last-y.last)*(x.last-y.last)
            }
            Array(p1, p2, p3, p4).combinations(2).foreach(p => set+= dis(p.head, p.last))
            set.size == 2
        }
    }
}