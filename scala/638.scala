object Solution {
    def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
        if (needs.forall(_ == 0)) 0
        else {
            var res = Int.MaxValue
            for (s <- special) {
                if (needs.zipWithIndex.forall{
                    case (v, i) => s(i) <= v
                }) {
                    res = res.min(s.last + shoppingOffers(price, special, needs.zipWithIndex.map{
                        case (v, i) => v - s(i)
                    }))
                }
            }
            res=res.min(needs.zip(price).foldLeft(0){
                case (total, (p, n)) => total + p*n
            })
            res
        }
    }
}