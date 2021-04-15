object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var carry = 1
    var res = digits
    res = digits.reverse.map(d => {val nd = (d+carry) % 10; carry = if (nd==0 && carry==1) 1 else 0; nd}).reverse
    if (carry == 1) res = 1 +: res
    res
  }
}

println(Solution.plusOne(Array(1,2,3,4)))
