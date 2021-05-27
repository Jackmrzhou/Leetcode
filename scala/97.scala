object Solution {
    def isInterleave(s1: String, s2: String, s3: String): Boolean = {
        if (s3.length() != s1.length() + s2.length()) return false
        val dp = Array.ofDim[Boolean](s1.length()+1, s2.length()+1)
        dp(0)(0) = true
        for ( i <- 1 to s1.length()) {
            dp(i)(0) = s1(i-1) == s3(i-1) && dp(i-1)(0)
        }
        for ( j <- 1 to s2.length()) {
            dp(0)(j) = s2(j-1) == s3(j-1) && dp(0)(j-1)
        }
        for (i <- 1 to s1.length()) {
            for (j <- 1 to s2.length()) {
                dp(i)(j) = (s1(i-1) == s3(i+j-1) && dp(i-1)(j)) || (s2(j-1) == s3(i+j-1) && dp(i)(j-1))
            }
        }
        dp.last.last
    }
}