object Solution {
    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
        var count = 0
        for (i <- 0 until flowerbed.length; if count < n) {
            if (flowerbed(i) == 0 && (i == 0 || flowerbed(i - 1) == 0) && (i == flowerbed.length - 1 || flowerbed(i + 1) == 0)) {
                flowerbed(i) = 1
                count += 1
            }
        }
        count == n
    }
}
