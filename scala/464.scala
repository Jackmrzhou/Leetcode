import scala.collection.mutable
object Solution {
    def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {
        if (maxChoosableInteger >= desiredTotal) return true
        if ((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) return false
        val mem = mutable.Map[Int, Boolean]()
        def dfs(comb: Int, dst: Int): Boolean = {
            if (mem.contains(comb)) mem(comb)
            else {
                for (i <- 0 until maxChoosableInteger; if (comb & (1<<i)) == 0) {
                    if (i+1 >= dst || !dfs(comb|(1<<i), dst - i - 1)) {
                        mem += (comb -> true)
                        return true
                    }
                }
                mem(comb) = false
                false
            }
        }
        dfs(0, desiredTotal)
    }
}