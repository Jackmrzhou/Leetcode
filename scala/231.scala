object Solution {
    def isPowerOfTwo(n: Int): Boolean = {
      if (n <= 0) return false
      n.toBinaryString.count(ch => ch=='1') == 1
    }
}
