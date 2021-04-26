object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
      s.zipWithIndex.foldLeft((true, Map[Char, Char]())){
        case ((res, charMap), (ch, i)) => {
          if (charMap.contains(ch)) {
            if (charMap(ch) == t(i))
              (res && true, charMap)
            else
              (false, charMap)
          } else if (charMap.exists({case (k, v) => v == t(i)})) {
            (false, charMap)
          } else {
            (res && true, charMap + (ch -> t(i)))
          }
        }
      }._1
    }
}
