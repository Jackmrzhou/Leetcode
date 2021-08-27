object Solution {
    def optimalDivision(nums: Array[Int]): String = {
        if (nums.length<=2) {
            nums.map(_.toString()).mkString("/")
        } else {
            nums.head.toString()+"/("+nums.slice(1, nums.length).map(_.toString()).mkString("/")+")"
        }
    }
}