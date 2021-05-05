object Solution {
    def rangeBitwiseAnd(left: Int, right: Int): Int = {
      if (left == 0 || right == 0) return 0
      val lb = left.toBinaryString
      val rb = right.toBinaryString
      if (lb.length() != rb.length()) return 0
      def findCommon(s1: String, s2: String, common: String): String = {
        if (s1.isEmpty() || s1.head != s2.head) return common
        return findCommon(s1.substring(1), s2.substring(1), common+s1.head).padTo(lb.length(), '0')
      }
      Integer.parseInt(findCommon(lb, rb, ""), 2)
    }
}
