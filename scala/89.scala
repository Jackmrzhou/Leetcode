object Solution {
    def grayCode(n: Int): List[Int] = {
        n match {
            case 1 => List(0, 1)
            case _ => {
                val codes = grayCode(n-1)
                codes ::: codes.reverse.map(_ + (1<<(n-1)))
            }
        }       
    }
}