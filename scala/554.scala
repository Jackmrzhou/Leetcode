import scala.collection.mutable
object Solution {
    def leastBricks(wall: List[List[Int]]): Int = {
        val map = mutable.Map[Int, Int]()
        wall.foreach(l=> {
            l.foldLeft(0){
                case (sum, n) => {
                    if (map.contains(sum)) map(sum) += 1
                    else map += (sum -> 1)
                    sum + n
                }
            }
        })
        wall.length-map.foldLeft(0){
            case (m, (k,v)) => if (k!=0) m.max(v) else m
        }
    }
}