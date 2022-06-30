package leetcodeJava;

import java.util.*;;
class Solution {
    final int visited = 101;
    public List<Integer> spiralOrder(int[][] matrix) {
        return walk(matrix, 0, 0, new int[]{0, 1}, 0);
    }
    public int[] nextDir(int[] dir) {
        if (dir[0] == 0 && dir[1] == 1) {
            return new int[]{1, 0};
        }
        if (dir[0] == 1 && dir[1] == 0) {
            return new int[]{0, -1};
        }
        if (dir[0] == 0 && dir[1] == -1) {
            return new int[]{-1, 0};
        }
        if (dir[0] == -1 && dir[1] == 0) {
            return new int[]{0, 1};
        }
        return null;
    }
    public List<Integer> walk(int[][] matrix, int i, int j, int[] dir, int count) {
        if (count == matrix.length * matrix[0].length) {
            return new LinkedList();
        }
        if (j+dir[1] >= matrix[0].length || j+dir[1] < 0 || i + dir[0] < 0 || i + dir[0] >= matrix.length || matrix[i+dir[0]][j+dir[1]] == visited) {
            dir = nextDir(dir);
        } 
        var v = matrix[i][j];
        matrix[i][j] = visited;
        var l = walk(matrix, i+dir[0], j+dir[1], dir, count+1);
        l.add(0, v);
        return l;
    }
}