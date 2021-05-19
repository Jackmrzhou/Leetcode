object Solution {
    def fib(n: Int): Int = {
        n match {
            case 0 => 0
            case 1 => 1
            case d => fib(d-1) + fib(d-2)
        }
    }
}
