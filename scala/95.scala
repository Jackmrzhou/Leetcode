import scala.collection.mutable.ListBuffer
object Solution {
    def generateTrees(n: Int): List[TreeNode] = {
        def gen(n: Int, start: Int): List[TreeNode] = {
          n match {
            case 0 => List(null)
            case 1 => List(TreeNode(1+start))
            case _ => {
              val res = ListBuffer[TreeNode]()
              for (i <- 0 until n) {
                val left = gen(i, start)
                val right = gen(n-1-i, i+1+start)
                for (l <- left; r <- right){
                  val head = TreeNode(i+1+start, l, r)
                  res += head
                }
              }
              res.toList
            }
          }
        }
        gen(n, 0)
    }
}