object Solution {
    def compareVersion(version1: String, version2: String): Int = {
        val v1 = version1.split("\\.")
        val v2 = version2.split("\\.")
        def cmp(versions1: Array[String], versions2: Array[String]): Int = {
            if (versions1.isEmpty && versions2.isEmpty) 0
            else if (versions1.isEmpty) {
                cmp(versions1 :+ "0", versions2)
            } else if (versions2.isEmpty) {
                cmp(versions1, versions2 :+ "0")
            }
            else {
                val a = versions1.head.toInt
                val b = versions2.head.toInt
                if (a > b) 1
                else if (a < b) -1
                else cmp(versions1.drop(1), versions2.drop(1))
            }
        }
        cmp(v1, v2)
    }
}