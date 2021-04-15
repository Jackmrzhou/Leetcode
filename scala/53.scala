object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    def  maxSub(left: Int, right: Int):Int = {
      if (left == right) return nums(left)
      val mid = (left + right) / 2
      val leftMax = maxSub(left, mid)
      val rightMax = maxSub(mid+1, right)
      var lMax = -100001
      var lSum = 0
      nums.slice(left, mid+1).reverse.foreach(num => {
        lSum += num
        lMax = lMax.max(lSum)
      })
      var rMax = -100001
      var rSum = 0
      nums.slice(mid+1, right+1).foreach(num => {
        rSum += num
        rMax = rMax.max(rSum)
      })
      leftMax.max(rightMax).max(lMax+rMax)
    }
    if (nums.length == 0) return 0
    maxSub(0, nums.length - 1)
  }
}

println(Solution.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))
