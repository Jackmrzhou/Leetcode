import scala.collection.mutable.Stack
object Solution {
    def nextGreaterElements(nums: Array[Int]): Array[Int] = {
        val res = Array.fill(nums.length)(-1)
        val stack = Stack[Int]()
        for (i <- 0 until nums.length*2) {
            val cur = nums(i%nums.length)
            while (stack.nonEmpty && cur > nums(stack.top)){
                res(stack.pop()) = cur
            }
            stack.push(i%nums.length)
        }
        res
    }
}