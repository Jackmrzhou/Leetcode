object Solution {
    def countNumbersWithUniqueDigits(n: Int): Int = {
        if (n==0) 1
        else if (n == 1) 10
        else (1 to n -1).foldLeft(10) {
            case (x, y) => (10 to 10-y by -1).foldLeft(1) {
                case (m, n) => m * n
            }/10*9 + x
        }
    }
}