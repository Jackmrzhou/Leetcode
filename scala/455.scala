import java.util.Arrays
object Solution {
    def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
        Arrays.sort(g)
        Arrays.sort(s)
        var i = 0
        var j = 0
        var count = 0
        while (i < g.length && j < s.length) {
            if (g(i) <= s(j)) {
                count += 1
                i += 1
                j += 1
            } else {
                j += 1
            }
        }
        count
    }
}