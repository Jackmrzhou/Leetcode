object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
      val sorted = nums.sorted
      def find(arr: Array[Int], target: Int): Int = {
        var l = 0
        var r = arr.length - 1
        var res = arr(l)+arr(r)
        while (l < r) {
          if ((res - target).abs >= (arr(l) + arr(r) - target).abs) res = arr(l) + arr(r)
          else if (res == target) return res
          if (arr(l) + arr(r) > target) r -= 1
          else l += 1
        }
        res
      }
      val res = for ( i <- 0 until (nums.length - 2) ) yield find(sorted.slice(i+1, nums.length), target - sorted(i)) + sorted(i)
      res.minBy(n => (n-target).abs)
    }
}
