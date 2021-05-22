object Solution {
    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
        for (i <- 0 until obstacleGrid.length; j <- 0 until obstacleGrid.head.length)
            if (obstacleGrid(i)(j) == 1) obstacleGrid(i)(j) = 0
            else {
                if (i==0&&j==0) obstacleGrid(0)(0) = 1 - obstacleGrid(0)(0)
                else if (i==0) obstacleGrid(0)(j) = obstacleGrid(0)(j-1)
                else if (j==0) obstacleGrid(i)(0) = obstacleGrid(i-1)(0)
                else obstacleGrid(i)(j) = obstacleGrid(i-1)(j) + obstacleGrid(i)(j-1)
            }
        obstacleGrid.last.last  
    }
}