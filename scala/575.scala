object Solution {
    def distributeCandies(candies: Array[Int]): Int = Math.min(candies.length / 2, candies.toSet.size)
}
