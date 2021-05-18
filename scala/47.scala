object Solution {
    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
      if (nums.length == 1) return List[List[Int]](List[Int](nums.head))
      permuteUnique(nums.slice(1, nums.length)).flatMap(p => {
        var last = -11
        val res = for ( i <- 0 until p.length; if p(i) != last) yield {
          last = p(i)
          (p.slice(0, i) :+ nums.head) ::: p.slice(i, p.length)
        }
        if (nums.head != p.last) res.toList :+ (p :+ nums.head)
        else res
      }).distinct
    }
}
println(Solution.permuteUnique(Array(1,1,2)))
