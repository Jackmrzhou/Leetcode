import scala.util.Try
object Solution {
    def validIPAddress(IP: String): String = {
        def parseV4(): String = {
            val sp = IP.split("\\.")
            sp.forall(str => {
                if (str.length() > 1 && str.head == '0' || str.length() > 3) false
                else {
                    val value = Try(str.toInt).toOption.getOrElse(-1)
                    if (value >= 0 && value <= 255) true
                    else false
                }
            }) && sp.length == 4 && IP.head != '.' && IP.last !='.' match {
                case true => "IPv4"
                case false => "Neither"
            }
        }
        def parseV6(): String = {
            val sp = IP.split(":")
            sp.forall(str => {
                if (str.length() > 4 || str.length() < 1) false 
                else {
                    str.forall(ch => {
                        ch.isDigit || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')
                    })
                }
            }) && sp.length == 8 && IP.head != ':' && IP.last != ':' match {
                case true => "IPv6"
                case false => "Neither"
            }
        }
        if (IP.exists(_ == '.')) parseV4()
        else if (IP.exists(_ == ':')) parseV6()
        else "Neither"
    }
}