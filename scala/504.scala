object Solution {
    def convertToBase7(num: Int): String = {
        def conv(num: Int): String = {
            if (num < 7) num.toString()
            else (num % 7).toString() + conv(num / 7)
        }
        if (num < 0) "-" + conv(num.abs).reverse
        else conv(num).reverse
    }
}