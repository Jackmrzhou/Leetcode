package leetcodeJava;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean r = false, c = false;
        int m = matrix.length, n = matrix[0].length;
        for (var i = 0; i < m; i++)
            if (matrix[i][0] == 0) c = true;
        for (var j = 0; j < n; j++)
            if (matrix[0][j] == 0) r = true;
        
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) r = true;
                    if (j == 0) c = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (var i = 1; i < m; i++) {
            for (var j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (r) 
            for (var j = 0; j < n; j++) matrix[0][j] = 0;
        if (c)
            for (var i = 0; i < m; i++) matrix[i][0] = 0;
    }
}

