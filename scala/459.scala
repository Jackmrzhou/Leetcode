object Solution {
    def repeatedSubstringPattern(s: String): Boolean = {
        for (i <- s.length() / 2 until 0 by -1) {
            val res = s.grouped(i).exists(str => str != s.slice(0, i))
            if (!res) return true
        }
        false
    }
}