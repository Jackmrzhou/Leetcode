object Solution {
    def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      val numMap = nums1.foldLeft(collection.mutable.Map[Int, Int]()) {
        case (m, num) => {
          if (m.contains(num)) {
            m(num) += 1
            m
          }
          else
            m + (num -> 1)
        }
      }
      nums2.filter(n => {
        if (numMap.contains(n)){
          if (numMap(n) >= 1) {
            numMap(n) -= 1
            true
          } else
              false
        } else {
          false
        }
      })
    }
}
