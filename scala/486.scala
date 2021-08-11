object Solution {
    def PredictTheWinner(nums: Array[Int]): Boolean = {
        def dfs(a: Int, b: Int, nums: Array[Int], turn: Boolean): Boolean = {
            if (nums.isEmpty) {
                a >= b
            }
            else {
                if (!turn) {
                    // a can win
                    dfs(a+nums.head, b, nums.drop(1), !turn) || dfs(a+nums.last, b, nums.dropRight(1), !turn)
                } else {
                    // whatever b takes, a can win then a can win
                    dfs(a, b+nums.head, nums.drop(1), !turn) && dfs(a, b+nums.last, nums.dropRight(1), !turn)
                }
            }
        }
        dfs(0, 0, nums, false)
    }
}