object Solution {
    def countNodes(root: TreeNode): Int = {
        def h(root: TreeNode, n: Int): Int = {
            if (root == null) n
            else h(root.left, n+1)
        }
        val height = h(root, 0)
        if (height == 0) return 0
        else if (height == 1) return 1
        
        val rightMost = (1<<(height-1))
        
        def test(i: Int): Boolean = {
            var l = 0 
            var r = rightMost
            var ptr = root
            var mid = -1
            while (l < r) {
                mid = l + (r-l)/2
                if (i < mid) {
                    ptr = ptr.left
                    r = mid
                } else {
                    ptr = ptr.right
                    l = mid + 1
                }
            }
            ptr != null
        }
        
        def findLast(l: Int, r: Int): Int = {
            if (l >= r) {
                if (l == 0) 1
                else l
            }
            else {
                val mid = l + (r-l) / 2
                if (test(mid)) findLast(mid+1, r)
                else findLast(l, mid)
            }
        }
        
        val last = findLast(0, rightMost)
        rightMost-1+last
    }
}