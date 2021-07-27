object Solution {
    def minMutation(start: String, end: String, bank: Array[String]): Int = {
        def valid(a: String, b: String): Boolean = {
            var diffCount = 0
            for (i <- 0 until a.length()) {
                if (a(i) != b(i)) diffCount += 1
            }
            diffCount == 1
        }

        def dfs(visited: Set[String], cur: String): Option[Int] = {
            if (cur == end && visited.nonEmpty) Option(0)
            else {
                var res = -1
                for (str <- bank; if !visited.contains(str) && valid(cur, str)) {
                    dfs(visited + cur, str) match {
                        case None => ()
                        case Some(value) => if (res == -1) res = 1+value else res = res.min(1+value)
                    }
                }
                if (res == -1) None
                else Option(res)
            }
        }

        if (bank.isEmpty) -1 
        else {
            dfs(Set(), start) match {
                case None => -1
                case Some(value) => value
            }
        }
    }
}