object Solution {
    def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
        val res = Array.fill(mat.length, mat.head.length)(30000)
        for (i <- 0 until mat.length; j <- 0 until mat.head.length) {
            if (mat(i)(j) == 0) res(i)(j) = 0
            else {
                if (i>0) res(i)(j) = res(i-1)(j) + 1
                if (j > 0) res(i)(j) = res(i)(j).min(res(i)(j-1) + 1)
            }
        }
        for (i <- mat.length-1 to 0 by -1; j <- mat.head.length-1 to 0 by -1; if res(i)(j) != 0) {
            if (i < mat.length-1) res(i)(j) = res(i)(j).min(res(i+1)(j)+1)
            if (j < mat.head.length-1) res(i)(j) = res(i)(j).min(res(i)(j+1)+1)
        }
        res
    }
}