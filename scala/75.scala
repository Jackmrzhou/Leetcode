object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        def swap(i: Int, j: Int) {
            val tmp = nums(i)
            nums(i) = nums(j)
            nums(j) = tmp
        }
        def sort(i: Int, l: Int, r: Int) {
            if (i <= r) 
              nums(i) match {
                  case 0 => { swap(l, i); sort(i+1, l+1, r) }
                  case 2 => { swap(i, r); sort(i, l, r-1) }
                  case _ => sort(i+1, l, r)
              }
        }       
        sort(0, 0, nums.length-1)
    }
}