object Solution {
  def lengthOfLastWord(s: String): Int = {
    var last = 0
    var sum = 0
    s.foreach(ch => {
      if (ch == ' ') {
        last = if (sum == 0) last else sum
        sum = 0
      } else {
        sum += 1
      }
    })
    if (sum == 0) last else sum
  }
}

println(Solution.lengthOfLastWord("hello world sg "))
