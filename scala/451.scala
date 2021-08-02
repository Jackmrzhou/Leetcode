import scala.collection.mutable
object Solution {
    def frequencySort(s: String): String = {
        val map = mutable.Map[Char, Int]().withDefaultValue(0)
        s.foreach(ch => map(ch) += 1)
        map.toList.sortBy(p => -p._2).map{
            case (k, v) => k.toString()*v
        }.mkString
    }
}