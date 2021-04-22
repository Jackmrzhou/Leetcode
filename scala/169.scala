object Solution {
    def majorityElement(nums: Array[Int]): Int = {
      val sortedNums = nums.sorted
      val res = sortedNums.foldLeft((0, 0, 0, 0)){
        case ((last, lastCount, i, maj), curVal) => {
          if (curVal == last)
            if (lastCount + 1 > maj)
              (last, lastCount + 1, last, lastCount+1)
            else
              (last, lastCount+1, i, maj)
            else {
              if (1 > maj)
                (curVal, 1, curVal, 1)
              else
                (curVal, 1, i, maj)
            }
        }
      }
      res._3
    }
}

println(Solution.majorityElement(Array(3,2,3)))
