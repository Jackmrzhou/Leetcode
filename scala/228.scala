object Solution {
    def summaryRanges(nums: Array[Int]): List[String] = {
      if (nums.isEmpty) return List[String]()
      var lastStart = nums.head
      var last = nums.head
      val list = for (num <- nums) yield {
        if (num > 1+last) {
          val res = if (last != lastStart) s"$lastStart->$last" else s"$lastStart"
          lastStart = num
          last = num
          res
        } else {
          last = num
          ""
        }
      }
      val lastRange = if (last != lastStart) s"$lastStart->$last" else s"$lastStart"
      list.filter(s => s!="").toList :+ lastRange
    }
}
