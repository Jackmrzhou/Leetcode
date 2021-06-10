import scala.collection.mutable.ListBuffer
object Solution {
    def diffWaysToCompute(expression: String): List[Int] = {
        if (expression.exists(p => p == '+' || p == '-' || p == '*')) {
            val res = ListBuffer[Int]
            for (i <- 0 until expression.length()) {
                expression(i) match {
                    case '+' => res += diffWaysToCompute(expression.slice(0, i)).flatMap(n => diffWaysToCompute(expression.slice(i+1, expression.length())).map(m => n+m))
                    case '-' => res += diffWaysToCompute(expression.slice(0, i)).flatMap(n => diffWaysToCompute(expression.slice(i+1, expression.length())).map(m => n-m))
                    case '*' => res += diffWaysToCompute(expression.slice(0, i)).flatMap(n => diffWaysToCompute(expression.slice(i+1, expression.length())).map(m => n*m))
                    case _ => ()
                }
            }
            res.toList
        } else {
            List(expression.toInt)
        }
    }
}