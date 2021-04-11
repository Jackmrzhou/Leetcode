object Solution {
  def reverse(x: Int): Int = {
    var res = 0
    val isNeg = x < 0
    var input = x
    while (input != 0){
      val last = input % 10
      input = input / 10
      val overflowLastDigit = if (isNeg) 8 else 7
      if (res.abs > 214748364 || ( res.abs == 214748364 && last > overflowLastDigit))
        return 0
      res = res * 10 + last
    }
    if ( !isNeg) res  else -res
  }
}

println(Solution.reverse(10))
println(Solution.reverse(123))
println(Solution.reverse(0))
println(Solution.reverse(1534236469))
println(Solution.reverse(-2147483648))
