import scala.collection.mutable.ListBuffer
object Solution {
    def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
        val sorted = people.sortBy(arr => (arr.head, arr.last))(Ordering.Tuple2(Ordering.Int.reverse, Ordering.Int))
        val res = ListBuffer[Array[Int]]()
        sorted.foreach(p => res.insert(p.last, p))
        res.toArray
    }
}