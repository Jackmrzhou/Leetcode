package leetcodeJava;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) 
                if (dfs(board, word, i, j)) return true;
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j) {
        if (word.length() == 0) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(0)) {
            return false;
        }
        var tmp = board[i][j];
        board[i][j] = ' ';
        var subWord = word.substring(1, word.length());
        if (dfs(board, subWord, i+1, j)) return true;
        if (dfs(board, subWord, i, j+1)) return true;
        if (dfs(board, subWord, i-1, j)) return true;
        if (dfs(board, subWord, i, j-1)) return true;
        board[i][j] = tmp;
        return false;
    }
}
