object Solution {
    def findMaximumXOR(nums: Array[Int]): Int = {
        var max = 0
        var mask = 0
        for (i <- 31 to 0 by -1) {
            mask = mask | (1 << i)
            val set = nums.foldLeft(Set[Int]()) {
                (s, n) => s + (n & mask)
            }
            val tmp = max | (1 << i)
            var break = false
            val iter = set.iterator
            while (!break && iter.hasNext) {
                val n = iter.next()
                val x = n ^ tmp
                if (set.find(p => p == x).nonEmpty) {
                    max = tmp
                    break = true
                }
            }
        }
        max
    }
}