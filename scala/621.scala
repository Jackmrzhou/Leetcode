object Solution {
    def leastInterval(tasks: Array[Char], n: Int): Int = {
        var map = Array.fill(26)(0)
        for (ch <- tasks) {
            map(ch-'A') += 1
        }
        var res = 0
        var used = 0
        while (used < tasks.length) {
            map = map.sorted.reverse
            for (i <- 0 to n) {
                res += 1
                if (i < map.size && map(i) != 0) {
                    used += 1
                    map(i) -= 1
                    if (used == tasks.length) {
                        return res
                    }
                }
            }
        }
        res
    }
}