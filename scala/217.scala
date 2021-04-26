object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
      !nums.sorted.foldLeft((true, 1000000001)){
        case ((res, last), num) => {
          if (num == last)
            (false, num)
          else
            (res && true, num)
        }
      }._1
    }
}
