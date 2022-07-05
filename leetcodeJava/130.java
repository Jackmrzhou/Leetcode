package leetcodeJava;

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (var i = 0; i < m; i++) {
            dfs(board,i, 0);
            dfs(board, i, n-1);
        }
        for (var j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        for (var i = 0; i < m; i++)
            for (var j = 0; j < n; j++)
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '-') board[i][j] = 'O';  
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '-';
            dfs(board, i+1, j);
            dfs(board, i, j+1);
            dfs(board, i-1, j);
            dfs(board, i, j-1);
        }
    }
}
