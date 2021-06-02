object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val m = wordDict.foldLeft(Map[String, Boolean]()) {
            case (m, word) => m + (word -> true)
        }
        val dp = Array.fill(s.length())(false)
        for (l <- 0 until s.length(); r <- l+1 until s.length()) {
            if (m.contains(s.slice(l, r))) {
                if (l == 0 || dp(l)) dp(r) = true
            }
        }
        dp.last
    }
}