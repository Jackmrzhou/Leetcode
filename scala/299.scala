import scala.collection.mutable
object Solution {
    def getHint(secret: String, guess: String): String = {
        var bs = 0
        var cs = 0
        val rest = new StringBuilder()
        val map = mutable.Map[Char, Int]()
        for (i <- 0 until secret.length()) {
            if (secret(i) == guess(i)) {
                bs += 1
            } else {
                rest += secret(i)
                if (map.contains(guess(i))) {
                    map(guess(i)) += 1
                } else {
                    map += (guess(i) -> 1)
                }
            }
        }
        for (ch <- rest) {
            if (map.contains(ch)) {
                cs += 1
                val count = map(ch)
                if (count == 1) {
                    map -= ch
                } else {
                    map += (ch -> (count - 1))
                }
            }
        }
        f"${bs}A${cs}B"
    }
}