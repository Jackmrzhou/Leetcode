object Solution {
    def compress(chars: Array[Char]): Int = {
        var i = 0
        var j = 0
        var last = chars.head
        while (i < chars.length) {
            var count = 0
            if (chars(i) != last) last = chars(i)
            while (i < chars.length && chars(i) == last) {
                count += 1
                i += 1
            }
            count match {
                case 1 => {
                    chars(j) = last
                    j += 1
                }
                case _ => {
                    chars(j) = last
                    j += 1
                    val countStr = count.toString()
                    for (k <- 0 until countStr.length) {
                        chars(j) = countStr(k)
                        j += 1
                    }
                }
            }
        }
        j
    }
}