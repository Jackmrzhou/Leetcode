import scala.collection.mutable.Queue
object Solution {
    def predictPartyVictory(senate: String): String = {
        val q1 = Queue[Char]()
        val q2 = Queue[Char]()
        senate.foreach(q1.enqueue)
        while (q1.nonEmpty) {
            if (q2.isEmpty || q1.front == q2.front) {
                q2.enqueue(q1.dequeue())
            } else {
                q1.enqueue(q2.dequeue())
                q1.dequeue()
            }
        }
        if (q2.dequeue() == 'R') "Radiant" else "Dire"
    }
}