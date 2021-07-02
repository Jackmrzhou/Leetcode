object Solution {
    def checkPerfectNumber(num: Int): Boolean = {
        (1 to math.sqrt(num).toInt).foldLeft(0){
            case (sum, n) => {
                if (num % n == 0) {
                    if (n * n == num || n == 1) sum + n
                    else sum + n + num / n
                } else {
                    sum
                }
            }
        } == num && num != 1
    }
}