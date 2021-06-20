object Solution {
    def isAdditiveNumber(num: String): Boolean = {
        def dfs(i :Int, last: Long, want: String): Boolean = {
            if (i == num.length()) true
            else if (num.slice(i, i+want.length()) == want) dfs(i+ want.length(), want.toLong, (last + want.toLong).toString)
            else false
        }
        for (i <- 1 until num.length(); j <- i until num.length()) {
            val a = num.slice(0, i)
            val b = num.slice(i, j)
            if (a.length()>1 && a(0) == '0' || b.length()>1 && b(0) == '0' || a.isEmpty() || b.isEmpty()) {

            } else {
               if(dfs(j, b.toLong, (a.toLong+b.toLong).toString())) return true
            }
        }
        false
    }
}