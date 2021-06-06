object Solution {
    def largestNumber(nums: Array[Int]): String = {
        val res = nums.map(x => x.toString()).sortWith((x,y) => (x+y).toLong > (y+x).toLong).mkString
        if (res.head == '0') "0" else res
    }
}