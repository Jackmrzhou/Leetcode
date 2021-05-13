object Solution {
    def letterCombinations(digits: String): List[String] = {
      val m = Map(
        '2' -> "abc",
        '3' -> "def",
        '4' -> "ghi",
        '5' -> "jkl",
        '6' -> "mno",
        '7' -> "pqrs",
        '8' -> "tuv",
        '9' -> "wxyz"
      )
      def gen(digits: String): List[String] = {
        if (digits.isEmpty()) return Nil
        val res = gen(digits.substring(1)) match {
            case Nil => List("")
            case default => default
        }
        m(digits.head).flatMap(ch => res.map(str => ch + str)).toList
      }
      gen(digits)
    }
}
