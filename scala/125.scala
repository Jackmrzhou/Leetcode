object Solution {
    def isPalindrome(s: String): Boolean = {
      val str = s.filter(ch => (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')).map(_.toLower)
      str == str.reverse
    }
}
