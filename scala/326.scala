object Solution {
    def isPowerOfThree(n: Int): Boolean = {
        if (n <= 0) return false
        if (n == 1) return true
        if (n % 3 != 0) return false
        isPowerOfThree(n/3)
    }
}

