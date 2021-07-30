import scala.collection.mutable
object Solution {
    def findAnagrams(s: String, p: String): List[Int] = {
        if (p.length() > s.length()) return Nil
        val map = Array.fill[Int](26)(0)
        p.foreach(ch => map(ch-'a') += 1)
        val res = mutable.ListBuffer[Int]()
        val count = Array.fill[Int](26)(0)
        for (i <- 0 until p.length()) {
            count(s(i)-'a') += 1
        }
        if (count.sameElements(map)) res += 0
        var i = p.length()
        while (i < s.length()) {
            if (s(i) == s(i-p.length()) && res.lastOption.getOrElse(-1) == (i - p.length())) { 
                i += 1
                res += i-p.length()
            } else {
                count(s(i) - 'a') += 1
                count(s(i-p.length()) - 'a') -= 1
                i += 1
                if (count.sameElements(map)) res += i-p.length()
            }
        }
        res.toList
    }
}