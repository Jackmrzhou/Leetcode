object Solution {
    def findTheDifference(s: String, t: String): Char = {
      val chCount = Array.ofDim[Int](26)
      s.foreach(ch => chCount(ch-'a') += 1)
      t.foreach(ch => chCount(ch -'a') -= 1)
      val index = chCount.indexWhere(c => c == -1)
      (index.getOrElse(0) + 'a'.toInt).toChar
    }
}
