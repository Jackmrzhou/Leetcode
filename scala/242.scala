object Solution {                                                  
    def isAnagram(s: String, t: String): Boolean = {
      val sMap = s.foldLeft(Map[Char, Int]()){
        case (m, ch) => {
          if (m.contains(ch))
            m + (ch -> (m(ch) + 1))
          else
            m + (ch -> 1)
        }
      }
      val tMap = t.foldLeft(Map[Char, Int]()){
        case (m, ch) => {
          if (m.contains(ch))
            m + (ch -> (m(ch) + 1))
          else
            m + (ch -> 1)
        }
      }
      sMap.equals(tMap)
    }
}
