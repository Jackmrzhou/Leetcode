import scala.annotation.tailrec
object Solution {
    @tailrec
    def isSubsequence(s: String, t: String): Boolean = {
      if (s.length() == 0) return true
      if (t.length() == 0) return false
      if (s.head == t.head) return isSubsequence(s.substring(1), t.substring(1))
      else return isSubsequence(s, t.substring(1))
    }
}
