object Solution {
    def numTrees(n: Int): Int = {
        if (n==0 ) return 1
        if (n == 1) return 1
        val res = (0 until n/2).foldLeft(0) {
            case (sum, i) => sum + numTrees(i) * numTrees(n-1-i)
        }   
        if ( n % 2 == 1) res*2 + numTrees(n/2)*numTrees(n/2)
        else res*2    
    }
}