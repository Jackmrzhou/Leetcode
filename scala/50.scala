object Solution {
    def myPow(x: Double, n: Int): Double = {
        def tailPow(x: Double, n: Int, res: Double): Double = {
            n match {
                case 0 => res
                case 1 => x * res
                case _ => tailPow(x, n/2, res*res)
            }
        }
        if (n > 0) tailPow(x, n, 1)
        else tailPow(1/x, -(n+1), 1/x)/x
    }
}