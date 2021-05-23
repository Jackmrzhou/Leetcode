object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        for (row <- matrix) {
            if (target <= row.last) {
                return row.find(_ == target).getOrElse(-1) != -1
            }
        }
        false
    }
}