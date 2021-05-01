object Solution {                                                  
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
      if (ransomNote.length() > magazine.length()) return false
      val chMap = magazine.foldLeft(collection.mutable.Map[Char, Int]()){
        case (m, ch) => {
          if (m.contains(ch)) {
            m(ch) += 1
            m
          } else {
            m + (ch -> 1)
          }
        }
      }
      !ransomNote.exists(ch => {
        if (chMap.contains(ch)) {
          if (chMap(ch) >= 1) {
            chMap(ch) -= 1
            false
          } else {
            true
          }
        } else
            true
      })
    }
}
