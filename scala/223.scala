object Solution {
    def computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int = {
        val x = 0.max(ax2.min(bx2) - ax1.max(bx1))
        val y = 0.max(ay2.min(by2) - ay1.max(by1))
        (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - x*y
    }
}