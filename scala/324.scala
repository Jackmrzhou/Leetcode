object Solution {
    def wiggleSort(nums: Array[Int]): Unit = {
        def swap(i: Int, j: Int) {
            val tmp = nums(i)
            nums(i) = nums(j)
            nums(j) = tmp
        }
        def partition(k: Int, l: Int, r: Int) {
            val p = nums(l)
            var i = l+1
            for (j <- i to r) {
                if (nums(j) <= p) {
                    swap(j, i)
                    i += 1
                }
            }
            i -= 1
            swap(l, i)
            if (i < k) partition(k, i+1, r)
            else if (i > k) partition(k, l, i-1)
        }
        partition(nums.length/2, 0, nums.length-1)
        var mid = nums(nums.length/2)
        var l = 0
        var r = nums.length - 1
        var i = r
        def ind(x: Int) = (1+x*2) % (nums.length | 1)
        while (i >= l) {
            if (nums(ind(i)) < mid) {
                swap(ind(i), ind(r))
                i -= 1
                r -= 1
            } else if (nums(ind(i)) > mid) {
                swap(ind(i), ind(l))
                l += 1
            } else i -= 1
        }
    }
}
Solution.wiggleSort(Array(5,5,5,4,4,4))
Solution.wiggleSort(Array(5,5,5,4,4,4,4))
Solution.wiggleSort(Array(5))
Solution.wiggleSort(Array(5,4))
Solution.wiggleSort(Array(5,4,4))
Solution.wiggleSort(Array(1,5,1,1,6,4))
Solution.wiggleSort(Array(4,5,5,6))