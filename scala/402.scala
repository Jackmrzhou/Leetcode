import scala.collection.mutable.Stack
object Solution {
    def removeKdigits(num: String, k: Int): String = {
        val stack = Stack[Int]()
        if (k == num.length()) "0"
        else {
            var count = k
            for (n <- num.map(_ - '0')) {
                while (stack.nonEmpty && count != 0 && stack.top > n) {
                    stack.pop()
                    count -= 1
                }
                stack.push(n)
            }
            while (stack.length > (num.length() - k)) stack.pop()
            val res = stack.mkString.reverse.dropWhile(_ == '0')
            if (res.isEmpty) "0" else res
        }
    }
}