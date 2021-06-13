object Solution {
    def licenseKeyFormatting(s: String, k: Int): String = {
        val res = new StringBuilder()
        var count = 0
        for (i <- s.length()-1 to 0 by -1) {
            if (count == k) {
                count = 0
                res += '-'
            }
            if (count<k && s(i) != '-') {
                res += s(i).toUpper
                count += 1
            }
        }
        if (count == 0 && res.length != 0) res.deleteCharAt(res.length-1)
        res.toString.reverse
    }
}