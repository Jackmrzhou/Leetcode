object Solution {
    def replaceWords(dictionary: List[String], sentence: String): String = {
        val map = dictionary.map(s => (s, true)).toMap
        sentence.split(" ").map(p => {
            var i = 1
            while (i <= p.length() && !map.contains(p.substring(0, i))) {
                i += 1
            }
            if (i == p.length()+1) p
            else p.substring(0, i)
        }).mkString(" ")
    }
}