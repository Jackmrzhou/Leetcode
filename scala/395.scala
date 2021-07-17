object Solution {
    def longestSubstring(s: String, k: Int): Int = {
        if (k > s.length) 0
        else {
            val m =  s.groupBy(identity).minBy(_._2.length())
            if (m._2.length() >= k) s.length()
            else s.split(m._1).map(s => longestSubstring(s, k)).max
        }
    }
}