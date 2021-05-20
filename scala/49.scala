object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        strs.foldLeft(Map[String, List[String]]()){
            case (res, str) => {
                val sorted = str.sorted
                if (res.contains(sorted)) {
                    res + (sorted -> (res(sorted) :+ str))
                } else {
                    res + (sorted -> List(str))
                }
            }
        }.values.toList
    }
}