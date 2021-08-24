object Solution {
    def complexNumberMultiply(num1: String, num2: String): String = {
        case class complex(re:Int, im: Int) {
            def *(that: complex) = complex(re*that.re-im*that.im, re*that.im+im*that.re)
            override def toString() = s"$re+${im}i"
        }
        def parse(s: String): complex = {
            val arr = s.split("\\+").map(s => if (s.contains("i")) s.substring(0, s.length()-1).toInt else s.toInt)
            complex(arr.head, arr.last)
        }
        (parse(num1)*parse(num2)).toString()
    }
}