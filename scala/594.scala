object Solution {
    def findLHS(nums: Array[Int]): Int = {
        val map = collection.mutable.HashMap[Int, Int]().withDefaultValue(0)
        var res = 0
        for (num <- nums) {
          map(num) += 1
          if (map.contains(num + 1)) res = res max (map(num) + map(num + 1))
          if (map.contains(num - 1)) res = res max (map(num) + map(num - 1))
        }
        res
    }
}
