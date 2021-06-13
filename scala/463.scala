object Solution {
    def islandPerimeter(grid: Array[Array[Int]]): Int = {
        var p = 0
        for (i <- 0 until grid.length; j <- 0 until grid.head.length) {
            if (grid(i)(j) == 1) {
                p += 4
                if (i-1 >= 0 && grid(i-1)(j) == 1) p -= 2
                if (j-1 >= 0 && grid(i)(j-1) == 1) p -= 2
            }
        }
        p
    }
}