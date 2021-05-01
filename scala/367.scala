object Solution {
    def isPerfectSquare(num: Int): Boolean = {
      def find(l: Int, r:Int): Boolean = {
        if (l>=r) return num % l == 0 && num / l == l
        val mid = l + (r-l) / 2
        if (num / mid > mid) return find(mid+1, r)
        else return find(l, mid)
      }
      find(1, num)
    }
}
