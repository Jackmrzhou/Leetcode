object Solution {
    def countArrangement(n: Int): Int = {
        val arr = (1 to n).toArray
        def swap(i: Int, j: Int) {
            val tmp = arr(i)
            arr(i) = arr(j)
            arr(j) = tmp
        }
        def dfs(l: Int): Int = {
            if (l > n) 1
            else {
                var res = 0
                for (i <- l to n; if (arr(i-1) % l == 0 || l % arr(i-1) == 0)) {
                    swap(l-1, i-1)
                    res += dfs(l+1)
                    swap(l-1, i-1)
                }
                res
            }
        }

        dfs(1)
    }
}