object Solution {
    def restoreIpAddresses(s: String): List[String] = {
        if (s.length()<4 || s.length() > 12) return Nil
        def isValid(s: String) {
            s.length() match {
                case 1 => true
                case 2 => s(1) != '0'
                case 3 => s(0) != '0' && s.toInt <= 255
            }
        }
        def search(s: String, ip: List[String], cur: Int): List[String] = {
            if (cur == 4) {
                if (s.isEmpty()) List(ip.mkString('.'))
                else Nil
            } else if (s.isEmpty) {
                Nil
            } else {
                var res = Nil
                for (i <- 1 to s.length().min(3)) {
                    if (isValid(s.slice(0, i))) {
                        res = res ::: search(s.slice(i, s.length()), ip :: s.slice(0, i), cur+1)
                    }
                }
                res
            }
        }
        search(s, Nil, 0)
    }
}