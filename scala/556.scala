object Solution {
    def nextGreaterElement(n: Int): Int = {
        val str = n.toString()
        val arr = str.permutations.toArray.sorted
        val i = arr.indexOf(str)
        for (j <- i until arr.length) {
            if (arr(j).toLong > n)  {
                if (arr(j).toLong > Int.MaxValue) return -1
                else return arr(j).toInt
            }
        }
        -1
    }
}