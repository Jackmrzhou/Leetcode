object Solution {
    def findLongestWord(s: String, dictionary: List[String]): String = {
        val sorted = dictionary.groupBy(_.length()).map(p => {
            (p._1, p._2.sorted)
        }).toList.sortBy(-_._1).flatMap(_._2)
        def contains(seq: String, str: String): Boolean = {
            var i = 0
            for (ch <- str; if i < seq.length()) {
                if (ch == seq(i)) i += 1
            }
            i == seq.length()
        }
        for (str <- sorted) {
            if (contains(str, s)) return str
        }
        ""
    }
}