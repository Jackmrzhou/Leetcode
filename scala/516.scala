object Solution {
    def longestPalindromeSubseq(s: String): Int = {
        val mem = Array.fill(s.length(), s.length())(-1)
        def search(l: Int, r: Int): Int = {
            if (l>r) 0
            else if (mem(l)(r) != -1) {
                mem(l)(r)
            } else {
                val res = if (l == r) 1 else {
                    if (s(l) == s(r)) 2+search(l+1, r-1)
                    else search(l+1, r).max(search(l, r-1))
                }
                mem(l)(r) = res
                res
            }
        }
        search(0, s.length()-1)
    }
}