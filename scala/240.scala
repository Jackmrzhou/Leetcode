object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        def s(i: Int, j: Int): Boolean = {
            if (i >= matrix.length || j < 0) false
            else {
                if (matrix(i)(j) == target) true
                else if (matrix(i)(j) < target) s(i+1, j)
                else s(i, j-1)
            }
        }
        s(0, matrix.head.length-1)
    }
}