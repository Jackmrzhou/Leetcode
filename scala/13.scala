object Solution {
  def romanToInt(s: String): Int = {
    val comb = Map(
      'V' -> 'I',
      'X' -> 'I',
      'C' -> 'X',
      'L' -> 'X',
      'D' -> 'C',
      'M' -> 'C'
    ).withDefaultValue(Nil)
    val valueMap = Map(
      'I' -> 1,
      'V' -> 5,
      'X' -> 10,
      'L' -> 50,
      'C' -> 100,
      'D' -> 500,
      'M' -> 1000
    )
    var prev = '\u0000'
    var res = 0
    var used = false
    for (ch <- s) {
      res += valueMap(ch)
      if (comb(ch) == prev && !used) {
        res -= 2 * valueMap(prev)
        used = true
      } else {
        used = false
      }
      prev = ch
    }
    res
  }
}

println(Solution.romanToInt("MCMXCIV"))
