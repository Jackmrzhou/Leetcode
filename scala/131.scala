import scala.collection.mutable.ListBuffer
object Solution {
    def test(s: String): Boolean = {
        s == s.reverse
    }
    def partition(s: String): List[List[String]] = {
        if (s.isEmpty()) List(Nil)
        else {
            val ans = ListBuffer[List[String]]()
            for (i <- 1 to s.length()) {
                val sub = s.slice(0, i)
                if (test(sub)) {
                    ans ++= partition(s.slice(i, s.length())).map(res => sub :: res).toList
                }
            }
            ans.toList
        }
    }
}