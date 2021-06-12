object Solution {
    def hIndex(citations: Array[Int]): Int = {
        val n = citations.length
        def search(l: Int, r: Int): Int = {
            if (l >= r) {
                if (citations(l) >= n - l) n-l
                else 0
            }
            else {
                val mid = l + (r-l) / 2
                if (citations(mid) >= n - mid) search(l, mid)
                else search(mid+1, r)
            }
        }
        search(0, n-1)
    }
}