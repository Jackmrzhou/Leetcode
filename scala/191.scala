object Solution {
    // you need treat n as an unsigned value
    def hammingWeight(n: Int): Int = {
      n.toBinaryString.foldLeft(0){
        case (count, ch) => count + ch-'0'
      }
    }
}
