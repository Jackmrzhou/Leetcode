object Solution {
    var max = 0
    def widthOfBinaryTree(root: TreeNode): Int = {
        max = 0
        if(root == null) 0 
        else {
            val queue = scala.collection.mutable.Queue[(TreeNode,Int)]() 
            queue.enqueue((root,1))
            while(queue.nonEmpty){
                var start = 0
                var end = 0
                val size = queue.size
                (1 to size).map{i =>
                    val (node,pos) = queue.dequeue
                    if(i == 1) start = pos
                    if(i == size) end = pos
                    if(node.left != null) queue.enqueue((node.left,2*pos))
                    if(node.right != null) queue.enqueue((node.right,2*pos+1))  
                }
                max = scala.math.max(max, end-start+1)
            }
            max  
        }
    }
}