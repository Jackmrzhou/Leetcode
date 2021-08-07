object Solution {
    def makesquare(matchsticks: Array[Int]): Boolean = {
        val pside = matchsticks.sum / 4
        if (matchsticks.sum % 4 != 0) return false
        def dfs(i: Int, a: Int, b: Int, c: Int, d: Int): Boolean = {
            if (!(a <= pside && b <= pside && c <= pside && d<= pside)) false
            else if (i == matchsticks.length) a == b && b == c && c == d
            else {
                dfs(i+1, a+matchsticks(i), b, c, d) || 
                dfs(i+1, a, b+matchsticks(i), c, d) || 
                dfs(i+1, a, b, c+matchsticks(i), d) || 
                dfs(i+1, a, b, c, d+matchsticks(i))
            }
        }
        dfs(0, 0, 0, 0, 0)
    }
}