object Solution {
    def lastRemaining(n: Int): Int = {
        if (n==1) 1
        else 2 * (n / 2 + 1 - lastRemaining(n / 2))
    }
}