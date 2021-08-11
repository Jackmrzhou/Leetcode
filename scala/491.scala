object Solution {
    def findSubsequences(nums: Array[Int]): List[List[Int]] = {
        def dfs(nums: Array[Int]): List[List[Int]] = {
            if (nums.length == 1) List(List(nums.head))
            else {
                dfs(nums.dropRight(1)).flatMap(l => {
                    if (l.last <= nums.last) List(l, l :+ nums.last)
                    else List(l)
                }).toList :+ List(nums.last)
            }
        }
        dfs(nums).filter(_.length != 1).distinct
    }
}