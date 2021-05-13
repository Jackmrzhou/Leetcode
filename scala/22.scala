import scala.collection.mutable.ListBuffer
object Solution {
    def generateParenthesis(n: Int): List[String] = {
      val l = ListBuffer[String]()
      def gen(n: Int, left: Int, res: String): Unit = {
        if (n == 0){
          l += res + List.fill(left)(')').mkString
        } else {
          gen(n-1, left + 1, res +'(')
          if (left != 0)
            gen(n, left - 1, res + ')')
        }
      }
      gen(n, 0, "")
      l.toList
    }
}
