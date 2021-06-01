object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        var l = 0
        var r = gas.length - 1
        var g = 0
        while (l < r) {
            if (g + gas(l) < cost(l)) {
                g += gas(r)-cost(r)
                r -= 1
            } else {
                g += gas(l) - cost(l)
                l += 1
            }
        }
        if (g + gas(l) < cost(l)) -1 
        else (l+1) % gas.length
    }
}