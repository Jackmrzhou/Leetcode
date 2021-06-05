object Solution {
    def findPeakElement(nums: Array[Int]): Int = {
        def find(l: Int, r:Int): Int = {
            if (l == r) l
            else if (l == r-1) {
                if (nums(l) > nums(r)) l
                else r
            } else {
                val mid = l + (r-l)/2
                if (nums(mid) < nums(mid+1)) find(mid+1, r)
                else find(l, mid)
            }
        }
        find(0, nums.length-1)
    }
}