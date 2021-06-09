object Solution {
    def calculate(s: String): Int = {
        def cal(s: String, res: Int): Int = {
            if (s.isEmpty()) res
            else {
                val op = s(0)
                var lastOp = '*'
                var num = 0
                var tempRes = 1
                var i = 1
                do {
                    num = 0
                    while (i < s.length() && (s(i) == ' ' || s(i) >= '0' && s(i) <= '9')) {
                        if (s(i) != ' ') {
                            num = num * 10 + (s(i) - '0')
                        }
                        i += 1
                    }
                    lastOp match {
                        case '*' => tempRes = tempRes * num
                        case '/' => tempRes = tempRes / num
                        case _ => tempRes = num
                    }
                    if (i < s.length()) {
                        lastOp = s(i)
                        i += 1
                    }
                } while ((lastOp == '*' || lastOp == '/') && i < s.length())
                op match {
                    case '+' => cal(s.slice(0, i+1), res + tempRes)
                    case '-' => cal(s.slice(0, i+1), res - tempRes)
                }
            }
        }
        cal('+' + s, 0)
    }
}