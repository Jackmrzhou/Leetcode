import scala.collection.mutable.Stack
object Solution {
  def isValid(s: String): Boolean = {
    var stack = Stack[Char]()
    val pairMap = Map(
      '}' -> '{',
      ']' -> '[',
      ')' -> '('
    )
    val res = for (ch <- s) yield {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch)
        true
      }
      else if (stack.isEmpty || pairMap(ch) != stack.pop())
        false
      else
        true
    }
    stack.isEmpty && !res.contains(false)
  }
}

println(Solution.isValid("[]{}()"))
println(Solution.isValid("[]]()"))
