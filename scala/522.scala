object Solution {
    def findLUSlength(strs: Array[String]): Int = {
        var res = -1
        def contains(seq: String, str: String): Boolean = {
            var i = 0
            for (ch <- str; if i < seq.length()) {
                if (ch == seq(i)) i += 1
            }
            i == seq.length()
        }
        for (j <- 0 until strs.length){
            if (!strs.zipWithIndex.exists(p => contains(strs(j), p._1) && p._2 != j)) {
                res = res.max(strs(j).length)
            }
        }
        res
    }
}