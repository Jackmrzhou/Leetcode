import scala.collection.mutable.ListBuffer
import scala.collection.immutable
import scala.collection.mutable.HashMap
class LRUCache(_capacity: Int) {
    case class node(key: Int, var value: Int)
    val l = ListBuffer[node]()
    val m = HashMap[Int, node]()

    def get(key: Int): Int = {
        m.get(key) match {
            case None => -1
            case Some(n) => {
                val v = n.value
                l -= n
                l += n
                v
            }
        }
    }

    def put(key: Int, value: Int) {
        if (get(key) != -1) {
            l.last.value = value
        } else {
            if (l.length == _capacity) {
                val n = l.head
                l -= n
                m -= n.key
            }
            val n = node(key, value)
            l += n
            m += (key -> n)
        }
    }
}