object Solution {
    def getMoneyAmount(n: Int): Int = {
        val mem = Array.fill(n+1, n+1)(-1)
        
        def get(l: Int, r: Int): Int = {
            if (l >= r) 0
            else if (mem(l)(r) != -1) mem(l)(r)
            else {
                val amount = (l to r).foldLeft(Int.MaxValue) {
                    case (amount, i) => amount.min(i+get(l, i-1).max(get(i+1, r)))
                }
                mem(l)(r) = amount
                amount
            }
        }
        get(1, n)
    }
}