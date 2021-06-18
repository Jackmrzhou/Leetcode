import scala.collection.mutable.Stack
import scala.collection.mutable
object Solution {
    def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        val stack = Stack[Int]()
        val map = mutable.Map[Int, Int]()
        for (n <- nums2) {
            while (!stack.isEmpty && stack.top < n) map += (stack.pop() -> n)
            stack.push(n)
        }
        while (!stack.isEmpty) {
            map += (stack.pop() -> -1)
        }
        nums1.map(map).toArray
    }
}