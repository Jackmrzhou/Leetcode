import scala.annotation.tailrec
object Solution {
    def findRepeatedDnaSequences(s: String): List[String] = {
      @tailrec
      def find(str: String, s1: Set[String], s2: Set[String]): Set[String] = {
        if (str.length() < 10 ) return s2
        val subStr = str.substring(0, 10)
        if (s1.contains(subStr)) return find(str.substring(1), s1, s2 + subStr)
        else return find(str.substring(1), s1 + subStr, s2)
      }
      find(s, Set[String](), Set[String]()).toList
    }
}
