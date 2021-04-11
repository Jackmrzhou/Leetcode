object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
     val res = for ((x, i) <- nums.view.zipWithIndex;
       (y, j) <- nums.view.zipWithIndex
       if x + y == target && i != j
      ) 
     yield {
       Array(i, j)
     }
     res.head
    }
}

Solution.twoSum(Array(1,2), 3)
