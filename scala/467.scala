import scala.collection.mutable
object Solution {
    def findSubstringInWraproundString(p: String): Int = {
        var i = 0
        var last = 0
        def next(ch: Char) = ch match {
            case 'z' => 'a'
            case _ => (ch.toInt+1).toChar
        }
        val range = Array.fill(26)(0)
        while (i < p.length()) {
            range(p(i)-'a') = range(p(i)-'a').max(1)
            while (i+1 < p.length() && p(i+1) == next(p(i))) {
                i += 1
                range(p(i)-'a') = range(p(i)-'a').max(i-last+1)
            } 
            i += 1
            last = i
        }
        range.sum
    }
}