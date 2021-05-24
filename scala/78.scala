object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] = {
        //(0 to nums.length).flatMap(nums.combinations(_)).map(_.toList).toList       
        nums match {
            case Array() => List(Nil)
            case default => {
                val withoutHead = subsets(nums.slice(1, nums.length))
                withoutHead ++ withoutHead.map(nums.head :: _)
            }
        }
    }
}