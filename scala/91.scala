object Solution {
    def numDecodings(s: String): Int = {
        val res = Array.fill[Int](s.length())(0)
        if (s.head == '0') return 0
        res(0) = 1
        for (i <- 1 until s.length()) {
            res(i) = if (s(i) != '0') res(i-1) else 0
            (s(i-1), s(i)) match {
                case v if (v._1 == '1' || (v._1 == '2' && v._2 >= '0' && v._2 <= '6')) => {
                  if (i-2>=0) res(i) += res(i-2) else res(i) += 1
                }
                case _ => 
            }
        }  
        res.last  
    }
}