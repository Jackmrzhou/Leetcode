object Solution {
    // you need treat n as an unsigned value
    def reverseBits(x: Int): Int = {
      Integer.parseUnsignedInt(x.toBinaryString.reverse.padTo(32, '0'), 2)
    }
}
