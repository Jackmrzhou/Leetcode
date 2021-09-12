object Solution {
    def countSubstrings(s: String): Int = {
        var res = 0
        def count(l: Int, r: Int) {
            if (l >= 0 && r < s.length() && s(l) == s(r)) {
                res += 1
                count(l-1, r+1)
            }
        }
        for (i <- 0 until s.length()) {
            count(i, i)
            count(i, i+1)
        }
        res
    }
}