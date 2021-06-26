import scala.collection.mutable.Stack
object Solution {
    def removeDuplicateLetters(s: String): String = {
        val map = Array.fill(26)(0)
        for (ch <- s) {
            map(ch - 'a') += 1
        }
        val stack = Stack[Char]()
        val used = Array.fill(26)(0)
        for (ch <- s) {
            if (used(ch - 'a') == 0) {
                while (stack.nonEmpty && stack.top > ch && map(stack.top - 'a') > 0) {
                    used(stack.pop() - 'a') = 0
                }
                used(ch - 'a') = 1
                stack.push(ch)
            }
            map(ch - 'a') -= 1
        }
        stack.mkString.reverse
    }
}