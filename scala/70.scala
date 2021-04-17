object Solution {
    def climbStairs(n: Int): Int = {
      def tailRec(n: Int, a: Int, b: Int): Int = n match {
	case 0 => a
        case _ => tailRec(n-1, b, a+b)
      }
      tailRec(n, 1, 1)
    }
}
