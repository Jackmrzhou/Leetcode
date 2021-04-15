import scala.collection.mutable.ArrayBuffer
object Solution {
  def addBinary(a: String, b: String): String = {
    val buf = ArrayBuffer.empty[Char]
    var carry = 0
    val (l, s) = if (a.length() > b.length()) (a.reverse,b.reverse) else (b.reverse,a.reverse)
    l.zipWithIndex.foreach{case (ch, i) => {
      val sCh = if (i >= s.length()) '0'  else s(i)
      val d = (ch, sCh, carry) match {
        case ('1', '0', 0) | ('0', '1', 0) | ('0', '0', 1) => carry = 0; '1'
        case ('0', '0', 0) => '0'
        case ('1', '0', 1) | ('0', '1', 1) | ('1', '1', 0) => carry = 1; '0'
        case ('1', '1', 1) => carry = 1; '1'
          // default logic to please complier
        case _ => '0'
      }
      buf += d
    }
    }
    if (carry == 1) buf += '1'
    buf.reverse.mkString
  }
}
