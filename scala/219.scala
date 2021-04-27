object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
      nums.zipWithIndex.foldLeft((false, Map[Int, Int]())){
        case ((found, indexMap), (num, index)) => {
          if (!indexMap.contains(num)) {
            (found | false, indexMap + (num -> index))
          } else {
            if ((indexMap(num) - index).abs <= k)
              (true, indexMap)
            else
              (found | false, indexMap + (num -> index))
          }
        }
      }._1
    }
}
