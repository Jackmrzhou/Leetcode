class MagicDictionary() {
    var dict: Array[String] = null
    def buildDict(dictionary: Array[String]) {
        dict = dictionary
    }

    def test(a: String, b: String): Boolean = {
        if (a.length() != b.length()) false
        else {
            var count = 0
            for (i <- 0 until a.length()) {
                if (a(i) != b(i)) {
                    count += 1
                }
                if (count > 1) return false
            }
            count == 1
        }
    }

    def search(searchWord: String): Boolean = {
        for (w <- dict) {
            if (test(w, searchWord)) return true
        }
        false
    }

}