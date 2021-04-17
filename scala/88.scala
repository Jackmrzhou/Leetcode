object Solution {
    def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
      var i = m-1
      var j = n-1
      while (i>= 0 && j>=0) {
        if (nums1(i) >= nums2(j)){
          nums1(i+j+1) = nums1(i)
          i--
        } else {
          nums1(i+j+1) = nums2(j)
          j--
        }
      }
      while(i>=0) {
        nums1(i+j+1) = nums1(i)
        i--
      }
      while (j>=0) {
        nums1(i+j+1) = nums2(j)
        j--
      }
    }
}
