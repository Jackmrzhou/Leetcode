/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */
import scala.annotation.tailrec
class Solution extends VersionControl {
    def firstBadVersion(n: Int): Int = {
        if (n == 1) return 1
        @tailrec
        def find(l: Int, r: Int): Int = {
          if (l >= r){
            return l
          }
          val mid = l+(r-l)/2
          val ml = isBadVersion(mid)
          if (ml == false) find(mid+1, r)
          else find(l, mid)
        }
        find(0, n)
    }
}
