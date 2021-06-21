object Solution {
    def findWords(words: Array[String]): Array[String] = {
        val row1 = "qwertyuiop".toSet
        val row2 = "asdfghjkl".toSet
        val row3 = "zxcvbnm".toSet
        words.filter(word => {
            val w = word.toLowerCase()
            w.forall(row1.contains) || w.forall(row2.contains) || w.forall(row3.contains)
        })
    }
}