object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        var last = nums.head
        var ptr = -1
        var count = 0
        nums.foreach(n => {
            if (last == n){
                count += 1
                if (count <= 2) {
                    ptr += 1
                }
            }
            else {
                ptr += 1
                count = 1
            }
            last = n
            nums(ptr) = n
        })
        ptr+1
    }
}
