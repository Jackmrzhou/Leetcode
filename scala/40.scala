import scala.collection.mutable.ListBuffer
object Solution {
    def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
      val l = ListBuffer[List[Int]]()
      def find(arr: Array[Int], t: Int, choose: List[Int]) {
        if (t == 0) l += choose
        else
          for (i <- 0 until arr.length; if arr(i) <= t; if i==0 || arr(i) != arr(i-1)){
            find(arr.slice(i+1, arr.length), t-arr(i), choose :+ arr(i))
          }
      }
      find(candidates.sorted, target, List[Int]())
      l.toList
    }
}
