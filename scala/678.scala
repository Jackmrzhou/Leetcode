object Solution {
    def checkValidString(s: String): Boolean = {
        var lo = 0
        var hi = 0
        for (ch <- s.toCharArray()) {
            if (ch == '(') lo += 1
            else lo -= 1
            if (ch != ')') hi += 1
            else hi -= 1
            if (hi < 0) return false
            lo = lo.max(0)
        }
        lo == 0
    }
}