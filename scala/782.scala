object Solution {
    def selfDividingNumbers(left: Int, right: Int): List[Int] = {
        (left to right).filter(p => p.toString().forall{
            ch => {
                ch != '0' && p % (ch -'0') == 0
            }
        }).toList
    }
}