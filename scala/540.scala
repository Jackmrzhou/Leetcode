object Solution {
    def singleNonDuplicate(nums: Array[Int]): Int = {
        def search(l: Int, r: Int): Int = {
            if (l>=r) nums(l)
            else {
                val leftCount = (r-l+1)/2
                val rightCount = (r-l+1)-leftCount-1
                val mid = (l+r)/2
                if (rightCount%2 == 1 && nums(mid) != nums(mid+1)) search(mid+1, r)
                else if ( rightCount%2==0 && nums(mid) == nums(mid+1)) search(mid, r)
                else if (leftCount % 2 == 0 && nums(mid) == nums(mid-1)) search(l, mid)
                else if (leftCount % 2 == 1 && nums(mid) != nums(mid-1)) search(l, mid-1)
                else nums(mid)
            }
        }
        search(0, nums.length-1)
    }
}