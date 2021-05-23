import scala.collection.mutable
object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {
        def set(i: Int, j: Int) {
            var _i = i-1
            var _j = j-1
            while (_i >= 0 && matrix(_i)(j) != 0) matrix(_i)(j) = 0
            _i = i+1
            while (_i < matrix.length && matrix(_i)(j) != 0) matrix(_i)(j) = 0
            while (_j >= 0 && matrix(i)(_j) != 0) matrix(i)(_j) = 0
            _j = j+1
            while (_j < matrix.head.length && matrix(i)(_j) != 0) matrix(i)(_j) = 0
        } 
        val s = mutable.Set[IndexedSeq[Int]]()
        for (i <- 0 until matrix.length; j <- 0 until matrix.head.length) 
            s.add((i, j))
        
        for (e <- s)
            set(e(0), e(1))
    }
}