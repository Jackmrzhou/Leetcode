package leetcodeJava;

class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();
        while (i < n && j < n) {
            while(i < n && start.charAt(i) == 'X') i++;
            while(j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) break;
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            } 
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        while(i < n && start.charAt(i) == 'X') i++;
        while(j < n && end.charAt(j) == 'X') j++;
        return i==n && j == n;
    }
}
