object Solution {
    def reverseString(s: Array[Char]): Unit = {
      def swap(i: Int, j: Int) {
        val tmp = s(i)
        s(i) = s(j)
        s(j) = tmp
      }
      for (i <- 0 until s.length / 2)
        swap(i, s.length - 1 - i)
    }
}
