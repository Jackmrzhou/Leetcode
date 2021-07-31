import scala.collection.mutable
object Solution {
    def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
        var res = 0
        for (i <- points) {
            val map = mutable.Map[Int, Int]().withDefaultValue(0)
            for (j <- points) {
                map((i.head - j.head)*(i.head - j.head) + (i.last - j.last)*(i.last - j.last)) += 1
            }
            for ((k, v) <- map){
                res += v * (v-1)
            }
        }
        res
    }
}