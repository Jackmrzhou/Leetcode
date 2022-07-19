package leetcodeJava;

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        var postSum = new int[shifts.length];
        long sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            postSum[i] = (int) sum;
        }
        var arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[i] = (char) ('a' +(arr[i] - 'a' + postSum[i]) % 26);
        }
        return String.valueOf(arr);
    }
}
