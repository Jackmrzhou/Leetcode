import scala.collection.mutable.ListBuffer
object Solution {
    def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
        if (x <= arr.head) {
            return arr.slice(0, k).toList
        } else if (x >= arr.last) {
            return arr.slice(arr.length-k, arr.length).toList
        }
        var ind = -1
        for (i <- 0 until arr.length; if arr(i) <= x) {
            ind = i
        }
        var l = ind
        var r = ind+1
        var count = 0
        while (l >= 0 && r < arr.length && count < k) {
            if (x-arr(l) <= arr(r)-x) {
                l -= 1
            } else {
                r += 1
            }
            count += 1
        }
        while (l >= 0 && count < k) {
            l -= 1
            count += 1
        }
        while (r < arr.length && count < k) {
            r += 1
            count += 1
        }
        arr.slice(l+1, r).toList
    }
}