object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.length == 0) return ""
    var res = List[Char]()
    var breakIt = false
    for( (ch, i) <- strs(0).zipWithIndex; if !breakIt ) {
      if ( strs.filter(str => str.length() > i && str(i) == ch).length == strs.length)
        res = res :+ ch
      else
        breakIt = true
    }
    res.mkString
  }
}

println(Solution.longestCommonPrefix(Array("asd", "as", "astt")))
