import scala.collection.mutable
object Solution {
    def isPossible(nums: Array[Int]): Boolean = {
        val freq = mutable.Map[Int, Int]().withDefaultValue(0)
        val need = mutable.Map[Int, Int]().withDefaultValue(0)
        nums.foreach(p => freq(p) += 1)
        for (n <- nums; if freq(n) != 0) {
            if (need(n) != 0) {
                freq(n) -= 1
                need(n) -= 1
                need(n+1) += 1
            } else if (freq(n+1) != 0 && freq(n+2) != 0) {
                freq(n) -= 1
                freq(n+1) -= 1
                freq(n+2) -= 1
                need(n+3) += 1
            } else {
                return false
            }
        }
        true
    }
}