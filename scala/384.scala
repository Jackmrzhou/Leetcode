import scala.util.Random
class Solution(_nums: Array[Int]) {

    /** Resets the array to its original configuration and return it. */
    def reset(): Array[Int] = {
        _nums
    }

    /** Returns a random shuffling of the array. */
    def shuffle(): Array[Int] = {
        Random.shuffle(_nums).toArray
    }

}
