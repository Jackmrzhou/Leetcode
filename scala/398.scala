import scala.collection.mutable
import scala.util.Random
class Solution(_nums: Array[Int]) {

    val map = {
        val m = mutable.Map[Int, mutable.ArrayBuffer[Int]]()
        for (i <- 0 until _nums.length) {
            m.get(_nums(i)) match {
                case None => m += (_nums(i) -> mutable.ArrayBuffer(i))
                case Some(value) => value += (i)
            }
        }
        m
    }

    def pick(target: Int): Int = {
        val arr = map(target)
        arr(Random.nextInt(arr.length))
    }

}