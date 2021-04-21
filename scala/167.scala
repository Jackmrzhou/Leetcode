object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
      for (i <- 0 until numbers.length - 1) {
        val min = 2 * numbers(i)
        val max = numbers(i) + numbers.last
        if (target >= min && target <= max) {
          for (j <- i+1 until numbers.length) {
            if (numbers(i)+numbers(j) == target)
              return Array(i, j)
          }
        }
      }
      Array(0,0)
    }
}
