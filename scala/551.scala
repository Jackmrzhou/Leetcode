object Solution {
    def checkRecord(s: String): Boolean = {
        s.indexOf("LLL") == -1 && s.count(_ == 'A') < 2
    }
}