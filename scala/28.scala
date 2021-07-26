object Solution {
  def strStr(haystack: String, needle: String): Int = {
    if (needle.length() == 0) return 0
    if (haystack.length() == 0) return -1
    return haystack.indexOf(needle)
  }
}
