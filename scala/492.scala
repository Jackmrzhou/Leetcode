object Solution {
    def constructRectangle(area: Int): Array[Int] = {
        for (i <- math.sqrt(area).toInt to 1 by -1) {
            if (area % i == 0) return Array(area / i, i)
        }
        Array(area, 1)
    }
}