object Solution {
  def firstUniqChar(s: String): Int = {
    val res = s.zipWithIndex.groupBy(_._1).filter(x => x._2.size == 1).values
    if (res.size == 0) return -1
    res.reduce((x,y) => {if (x.head._2 < y.head._2) x else y}).head._2
  }
}
