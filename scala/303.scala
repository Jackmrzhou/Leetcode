class NumArray(_nums: Array[Int]) {

  val sums = {
    val arr = Array.ofDim[Int](_nums.length + 1)
    arr(_nums.length) = (0 +: _nums).zipWithIndex.reduce((x,y) => {arr(x._2) = x._1; (x._1 + y._1, y._2)})._1
    arr
  }
    def sumRange(left: Int, right: Int): Int = {
      sums(right+1) - sums(left)
    }

}
