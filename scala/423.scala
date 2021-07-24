object Solution {
    def originalDigits(s: String): String = {
        val words = Array("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val map = Array.ofDim[Int](26)
        s.foreach(ch => map(ch-'a') += 1)
        val res = Array.ofDim[Int](10)
        def getAll(i: Int, ch: Char) {
            while(map(ch-'a') != 0) {
                res(i) += 1
                words(i).foreach(c => map(c-'a') -= 1) 
            }
        }
        getAll(0, 'z')
        getAll(2, 'w')
        getAll(4, 'u')
        getAll(3, 'r')
        getAll(6, 'x')
        getAll(8, 'g')
        getAll(7, 's')
        getAll(5, 'v')
        getAll(9, 'i')
        getAll(1, 'n')
        val sb = new StringBuilder()
        for (i <- 0 until res.length; if res(i) != 0) {
            sb ++= i.toString * res(i)
        }
        sb.toString()
    }
}