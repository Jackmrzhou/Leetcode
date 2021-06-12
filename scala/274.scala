object Solution {
    def hIndex(citations: Array[Int]): Int = {
        for (h <- n to 1 by -1) {
            if (citations.count(p => p >= h) >= h) return h
        }
        0
    }
}