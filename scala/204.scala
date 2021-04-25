object Solution {
    def countPrimes(n: Int): Int = {
      val isPrime = Array.fill(n+2)(true)
      if (n <= 1) return 0
      def checkPrime(i: Int): Boolean = {
        !(2 to scala.math.sqrt(i).toInt).exists(x => i % x == 0)
      }
      for (i <- 2 to math.sqrt(n).toInt) {
        if (checkPrime(i)) {
          for (j <- i * i to n by i) {
            isPrime(j) = false
          }
        }
      }
      isPrime.slice(2, n).foldLeft(0){
        case (count, prime) =>  if (prime) count + 1 else count
      }
    }
}
