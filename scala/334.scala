object Solution {
    def increasingTriplet(nums: Array[Int]): Boolean = {
        if (nums.length < 3) return false
        var a: Integer = null
        var b: Integer = null
        var c: Integer = null
        def isSorted = a < b && b < c
        nums.foreach(n => {
            if (a == null) a = n
            else if (b == null) b = n
            else if (c == null) {
                if (n > b && n <= a) {
                    a = b
                    b = n
                } else if (n > b && n > a && b > a) {
                    return true
                } else if (n > b || n < b && n > a) {
                    b = n
                } else if (n < b) {
                    c = n
                }
            } else if (n < c) {
                c = n
            } else if (n > c) {
                if (n > b && n > a && b > a) return true
                a = c
                b = n
            }
        })
        isSorted
    }
}