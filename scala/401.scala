object Solution {
    def readBinaryWatch(turnedOn: Int): List[String] = {
      val hours = Array[Int](8,4,2,1)
      val mins = Array[Int](32,16,8,4,2,1)
      val res = for (i <- 0 to turnedOn) yield {
        if (i == 0) {
          mins.combinations(turnedOn - i).map(arr => arr.sum).filter(_ < 60).map(m => f"0:$m%02d")
        } else if (i <= 4) {
          val hs = hours.combinations(i).map(arr => arr.sum).filter(_ <= 11)
          val ms = mins.combinations(turnedOn - i).map(arr => arr.sum).filter(_ < 60).toList
          hs.flatMap(h => ms.map(m=> f"$h%d:$m%02d"))
        } else {
          List[String]()
        }
      }
      res.flatten.toList
    }
}
