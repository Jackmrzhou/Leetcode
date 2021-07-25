object Solution {
    def construct(grid: Array[Array[Int]]): Node = {
        def cons(i1: Int, j1: Int, i2: Int, j2: Int): Node = {
            if (i1 == i2 && j1 == j2)  {
                val node = new Node(grid(i1)(j1) == 1, true)
                node
            }
            else {
                val topLeft = cons(i1, j1, (i1+i2)/2, (j1+j2)/2)
                val topRight = cons(i1, (j1+j2+1)/2, (i1+i2)/2, j2)
                val bottomLeft = cons((i1+i2+1)/2, j1, i2, (j1+j2)/2)
                val bottomRight = cons((i1+i2+1)/2, (j1+j2+1)/2, i2, j2)
                if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                    if (topLeft.value && topRight.value && bottomLeft.value && bottomRight.value ||
                       !topLeft.value && !topRight.value && !bottomLeft.value  && !bottomRight.value ){
                        val node = new Node(topLeft.value, true)
                        node
                    } else {
                        val node =  new Node(true, false)
                        node.topLeft = topLeft
                        node.topRight = topRight
                        node.bottomLeft = bottomLeft
                        node.bottomRight = bottomRight
                        node
                    }
                } else {
                   val node =  new Node(true, false)
                    node.topLeft = topLeft
                    node.topRight = topRight
                    node.bottomLeft = bottomLeft
                    node.bottomRight = bottomRight
                    node
                }
            }
        }
        cons(0, 0, grid.length-1, grid.head.length-1)
    }
}