import scala.collection.mutable.Stack
object Solution {
    def circularArrayLoop(nums: Array[Int]): Boolean = {
        val visited = 20000
        val stack = Stack[Int]()
        for (i <- 0 until nums.length; if nums(i) != 0) {
            var j = i
            val sign = if (nums(i) > 0) 1 else -1
            var last = 0
            while(nums(j) * sign > 0 && nums(j) != visited && nums(j) != 0) {
                stack.push(j)
                // visited
                val tmp = nums(j)
                nums(j) = visited
                last = j
                j = j+tmp
                if (j < 0) j = nums.length - 1 - ((j.abs-1) % nums.length)
                else j = j % nums.length
            }
            if (nums(j) == visited && j != last) return true
            else {
                while (stack.nonEmpty) {
                    nums(stack.pop()) = 0
                }
            }
        }
        false
    }
}