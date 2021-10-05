object Solution {
    def topKFrequent(words: Array[String], k: Int): List[String] = {
        words.foldLeft(Map[String, Int]()){
            case (m, w) => m + (w -> (m.getOrElse(w, 0)+1))
        }
        .toList
        .sortBy(r => (-r._2, r._1))
        .map(_._1)
        .slice(0, k)
    }
}