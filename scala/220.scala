import java.util.TreeSet
object Solution {
    def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
        val set = new TreeSet[java.lang.Long]()
        for (i <- 0 until nums.length) {
            val n = set.ceiling(nums(i).toLong - t)
            if (n != null && n <= nums(i).toLong + t) return true
            set.add(nums(i))
            if (set.size > k) set.remove(nums(i-k).toLong)
        }
        false
    }
}