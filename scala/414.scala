import scala.collection.mutable
object Solution {
    def thirdMax(nums: Array[Int]): Int = {
      val maxSet = mutable.Set[Int]()
      for (num <- nums) {
        if (maxSet.size < 3) maxSet.add(num)
        else {
          if (!maxSet.contains(num) && num > maxSet.min) {
            maxSet.add(num)
            maxSet.remove(maxSet.min)
          }
        }
      }
      if (maxSet.size < 3) maxSet.max
      else maxSet.min
    }
}
