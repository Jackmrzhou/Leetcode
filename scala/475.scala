object Solution {
    def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
        val sho = houses.sorted
        val she = (-1e9-1).toInt +: heaters.sorted :+ Int.MaxValue
        var i = 0
        var j = 0
        var res = 0
        while (i < sho.length) {
            if(sho(i) >= she(j) && sho(i) <= she(j+1)) {
                res = res.max((sho(i)-she(j)).min(she(j+1)-sho(i)))
                i += 1
            } else {
                j += 1
            }
        }
        res
    }
}