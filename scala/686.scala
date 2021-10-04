object Solution {
    def repeatedStringMatch(a: String, b: String): Int = {
        var rep = b.length() / a.length()
        val str = a * rep
        if (str.contains(b)) rep
        else if ((a+str).contains(b)) rep + 1
        else if ((a+str+a).contains(b)) rep + 2
        else -1
    }
}