import scala.collection.mutable.Stack
object Solution {
    def find132pattern(nums: Array[Int]): Boolean = {
        val stack = Stack[Int]()
        var s3 = Int.MinValue
        for (n <- nums.reverse) {
            if (n < s3) return true
            while(stack.nonEmpty && n > stack.top) {
                s3 = stack.top
                stack.pop()
            }
            stack.push(n)
        }
        false
    }
}