import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer
import scala.util.Random
class RandomizedSet() {

    /** Initialize your data structure here. */
    val map = Map[Int, Int]()
    val nums = ArrayBuffer[Int]()
    

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    def insert(`val`: Int): Boolean = {
        if (map.contains(`val`)) return false
        nums += `val`
        map += (`val` -> (nums.length - 1))
        true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    def remove(`val`: Int): Boolean = {
        if (!map.contains(`val`)) return false
        val last = nums.last
        map.update(last, map(`val`))
        nums(map(`val`)) = last
        nums(nums.length - 1) = `val`
        nums.remove(nums.length - 1)
        map -= `val`
        true
    }

    /** Get a random element from the set. */
    def getRandom(): Int = {
        nums(Random.nextInt(nums.length))
    }

}