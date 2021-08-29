object Solution {
    def intersect(quadTree1: Node, quadTree2: Node): Node = {
        if (quadTree1 == null || quadTree2 == null) null
        else if (quadTree1.isLeaf) {
            if (quadTree1.value) {
                quadTree1
            } else {
                quadTree2
            }
        } else if (quadTree2.isLeaf) {
            if (quadTree2.value)
                quadTree2
            else quadTree1
        } else {
            val tl = intersect(quadTree1.topLeft, quadTree2.topLeft)
            val tr = intersect(quadTree1.topRight, quadTree2.topRight)
            val bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
            val br = intersect(quadTree1.bottomRight, quadTree2.bottomRight)
            val isLeaf = tl.value == tr.value && tr.value == bl.value && bl.value == br.value && tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
            val value = if (isLeaf) tl.value else false
            val n = new Node(value, isLeaf)
            if (!isLeaf) {
                n.topLeft = tl
                n.topRight = tr
                n.bottomLeft = bl
                n.bottomRight = br
            }
            n
        }
    }
}