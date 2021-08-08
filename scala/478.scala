import scala.util.Random
class Solution(_radius: Double, _x_center: Double, _y_center: Double) {

    def randPoint(): Array[Double] = {
        val r = math.sqrt(Random.nextDouble()) * _radius 
        val alpha = Random.nextDouble() * 2 * math.Pi
        val x = r*math.cos(alpha)
        val y = r*math.sin(alpha)
        Array(x+_x_center, y+_y_center)
    }

}