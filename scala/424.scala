import scala.collection.mutable
object Solution {
    def characterReplacement(s: String, k: Int): Int = {
        var l = 0
        var r = 0
        var res = 0
        val map = mutable.Map[Char, Int]()
        map += (s(l) -> 1)
        while (l <= r) {
            val len = map.maxBy{case (k, v) => v}._2
            if (r-l+1-len > k) {
                map(s(l)) -= 1
                l += 1
            } else {
                res = res.max(r-l+1)
                if (r < s.length - 1) {
                    r += 1
                    if (map.contains(s(r))) {
                        map(s(r)) += 1
                    } else {
                        map(s(r)) = 1
                    }
                } else {
                    return res
                }
            } 
        }
        res
    }
}