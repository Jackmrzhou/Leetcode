object Solution {
    def reverseStr(s: String, k: Int): String = {
        s.grouped(2*k).map(str => str.grouped(k).toList match {
            case head :: sec :: tl => head.reverse + sec
            case head :: tl => head.reverse
            case _ => ""
        }).mkString
    }
}