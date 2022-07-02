package leetcodeJava;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var i = 0;
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) break;
        }
        if (!(i == matrix.length-1 && target >= matrix[i][0]) && i != 0) {
           i--; 
        } 
        for (var j = 0; j < matrix[0].length; j++)
            if (matrix[i][j] == target) return true;
        return false;
    }
    
}