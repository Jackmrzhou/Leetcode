object Solution {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    val map = list1.zipWithIndex.toMap
    def go(acc: List[String], i: Int, arr: Array[String], min: Int): Array[String] = {
      if (i == arr.length) acc.toArray
      else {
        map
          .get(arr(i))
          .fold {
            go(acc, i + 1, arr, min)
          } { j =>
            val newMin = i + j
            if (newMin < min) go(List(arr(i)), i + 1, arr, newMin)
            else if (newMin == min) go(acc :+ arr(i), i + 1, arr, min)
            else go(acc, i + 1, arr, min)
          }
      }
    }

    go(Nil, 0, list2, Int.MaxValue)
  }
}
