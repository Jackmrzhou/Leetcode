object Solution {
    def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
        val counts = strs.map(str => (str.count(_ =='0'), str.count(_=='1'))).toArray
        val dp = Array.fill(m+1, n+1)(0)
        for (count <- counts) {
            for (i <- m to count._1 by -1; j <- n to count._2 by -1) 
                dp(i)(j)  = dp(i)(j).max(dp(i-count._1)(j-count._2) + 1)
        }
        dp.last.last
    }
}