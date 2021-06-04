import scala.collection.mutable.Stack
object Solution {
    def evalRPN(tokens: Array[String]): Int = {
        val stack = Stack[Int]()
        tokens.foreach {
            token => token match {
                case "+" => {
                    stack.push(stack.pop + stack.pop)
                }
                case "-" => {
                    val a = stack.pop()
                    val b = stack.pop()
                    stack.push(b - a)
                }
                case "*" => {
                    stack.push(stack.pop * stack.pop)
                }
                case "/" => {
                    val a = stack.pop()
                    val b = stack.pop()
                    stack.push(b / a)
                }
                case _ => {
                    stack.push(token.toInt)
                }
            }
        }
        stack.pop     
    }
}