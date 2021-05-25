object Solution {
    def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
       (0 to nums.length).flatMap(nums.combinations(_)).map(_.toList).toList  
    }
}