object Solution {
    def matrixReshape(mat: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
        if (r*c != mat.length * mat.head.length) mat
        else {
            val res = Array.ofDim[Int](r, c)
            for (i <- 0 until mat.length; j <- 0 until mat.head.length) {
                res((i*mat.head.length+j)/c)((i*mat.head.length+j)%c) = mat(i)(j)
            }
            res
        }
    }
}
