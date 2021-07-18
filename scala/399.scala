import scala.collection.mutable
object Solution {
    def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
        case class pair(value: Double, id: String)
        val g = mutable.Map[String, mutable.ListBuffer[pair]]()
        for (i <- 0 until equations.length) {
            val a = equations(i).head
            val b = equations(i).last
            if (g.contains(a)) {
                g(a) += pair(values(i), b)
            } else {
                g += (a -> mutable.ListBuffer(pair(values(i), b)))
            }
            if (g.contains(b)) {
                g(b) += pair(1/values(i), a)
            } else {
                g += (b -> mutable.ListBuffer(pair(1/values(i), a)))
            }
        }
        def dfs(a: String, b: String, res: Double, visited: Set[String]): Double = {
            if (!g.contains(a)) -1
            else {
                g(a).find(p=>p.id == b) match {
                    case None => {
                        for (p <- g(a); if !visited.contains(p.id)) {
                            val tmp = dfs(p.id, b, res*p.value, visited + p.id)
                            if (tmp != -1) return tmp
                        }
                        -1
                    }
                    case Some(v) => res * v.value
                }
            }
        }
        queries.foldLeft(Array[Double]()){
            case (res, query) => res :+ dfs(query.head, query.last, 1, Set[String](query.head))
        }
    }
}