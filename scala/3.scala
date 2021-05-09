import scala.collection.mutable
object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
      var l = 0
      var r = 0
      var set = mutable.Set[Char]()
      var res = 0
      while ( r < s.length() ) {
        if (set.contains(s(r))) {
          while ( s(l) != s(r) ) { 
              set.remove(s(l))
              l += 1
          }
          l += 1
        } else {
          set.add(s(r))
        }
        r += 1
        res = res.max(r-l)
      }
      res
    }
}
