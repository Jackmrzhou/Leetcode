object Solution {
    def magicalString(n: Int): Int = {
        val sb = new StringBuilder("122")
        var i = 1
        var j = 3
        while (j < n) {
            val next = sb(j-1) match {
                case '1' => '2'
                case '2' => '1'
            }
            i += 1
            val len = sb(i) - '0'
            j += len
            sb ++= next.toString() * len
        }
        sb.slice(0, n).count(_ == '1')
    }
}