import scala.collection.mutable
object Solution {
    def findItinerary(tickets: List[List[String]]): List[String] = {
        case class node(value: String, var times: Int) extends Ordered[node] {
            def compare(that: node): Int = this.value compareTo that.value
        }
        val g = mutable.Map[String, mutable.SortedSet[node]]()
        tickets.foreach(p => {
            if (g.contains(p.head)) {
                g(p.head).find(n => n.value == p.last) match {
                    case None => g(p.head) += node(p.last, 1)
                    case Some(value) => value.times += 1
                }
            } else {
                g += (p.head -> mutable.SortedSet(node(p.last, 1)))
            }
        })
        var res = List[String]()
        def dfs(cur: String, path: List[String], left: Int): Boolean = {
            if (left == 0) {
                res = path
                true
            } else if (!g.contains(cur) || g(cur).isEmpty) {
                false
            } else {
                val q = g(cur)
                for (e <- q.toList){
                    e.times -= 1
                    if (e.times == 0) {
                        q.remove(e)
                    }
                    if (dfs(e.value, path :+ e.value, left - 1)) return true
                    else {
                        if (e.times == 0)
                            g(cur).add(e)
                        e.times += 1
                    }
                }
                false
            }
        }
        dfs("JFK", List("JFK"), tickets.length)
        res
    }
}