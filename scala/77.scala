object Solution {
    def combine(n: Int, k: Int): List[List[Int]] = {
        (1 to n).combinations(k).map(l => l.toList).toList       
    }
}