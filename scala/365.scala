object Solution {
    def canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean = {
        def gcd(a: Int, b: Int): Int = {
            if (b == 0) a
            else gcd(b, a%b)
        }
        if (jug2Capacity + jug1Capacity >= targetCapacity && targetCapacity % gcd(jug2Capacity, jug1Capacity) == 0) true
        else false
    }
}