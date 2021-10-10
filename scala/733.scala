object Solution {
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        val start = image(sr)(sc)
        if (start == newColor) return image
        val r = image.length
        var c = image.head.length
        def dfs(i: Int, j: Int) {
            if (i >= 0 && i < r && j >= 0 && j < c) {
                if (image(i)(j) == start) {
                    image(i)(j) = newColor
                    dfs(i-1,j)
                    dfs(i+1,j)
                    dfs(i,j-1)
                    dfs(i,j+1)
                }
            }
        }
        dfs(sr,sc)
        image
    }
}