object Solution {
    def hammingDistance(x: Int, y: Int): Int = {
        (x^y).toBinaryString.count(_ == '1')
    }
}