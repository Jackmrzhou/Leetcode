import scala.collection.mutable
object Solution {
    def checkInclusion(s1: String, s2: String): Boolean = {
        if (s1.length() > s2.length()) false
        else {
            val m = s1.foldLeft(Map[Char, Int]()){
                case (m, ch) => m + (ch -> (m.getOrElse(ch, 0) + 1))
            }
            val len = s1.length()
            val charCount = mutable.Map[Char, Int]()
            s2.slice(0, len).foreach(ch => charCount += (ch -> (charCount.getOrElse(ch, 0) + 1)))
            if (charCount.equals(m)) return true
            for (i <- len until s2.length()) {
                val head = s2(i-len)
                val tail = s2(i)
                charCount(head) -= 1
                if (charCount(head) == 0) charCount.remove(head)
                charCount += (tail -> (charCount.getOrElse(tail, 0) + 1))
                if (charCount.equals(m)) return true
            }
            false
        }
    }
}