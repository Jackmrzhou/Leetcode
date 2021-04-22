object Solution {
    def titleToNumber(columnTitle: String): Int = {
      columnTitle.foldLeft(0){
        case (sum, ch) => {
          sum * 26 + ch.toInt - 'A'.toInt + 1
        }
      }
    }
}
