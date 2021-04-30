object Solution {
    def wordPattern(pattern: String, s: String): Boolean = {
      val words = s.split(" ")
      if (pattern.length() != words.length) return false
      pattern.zipWithIndex.foldLeft((true, Map[Char, String]())){
        case ((res, m), (ch, i)) => {
          if (m.contains(ch)) {
            if (m(ch) == words(i))
              (res && true, m)
            else
              (false, m)
          } else {
            if (m.exists(e => e._2 == words(i)))
              (false, m)
            else
              (res && true, m + (ch -> words(i)))
          }
        }
      }._1
    }
}
