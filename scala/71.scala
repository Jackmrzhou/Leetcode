import scala.collection.mutable.Stack
object Solution {
    def simplifyPath(path: String): String = {
        val tokens = path.split('/')
        val stack = Stack[String]()
        for (token <- tokens) {
            token match {
                case "/" | "." | "" => ()
                case ".." => {
                    if (!stack.isEmpty) stack.pop()
                }
                case _ => stack.push(token)
            }
        }       
        "/" + stack.reverse.mkString("/")
    }
}