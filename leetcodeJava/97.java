package leetcodeJava;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0 && s2.length() == 0) return true;
        var dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (var i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i))
                dp[i+1][0] = dp[i][0];
        }
        for (var j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == s3.charAt(j))
                dp[0][j+1] = dp[0][j];
        }
        for (var i = 0; i < s1.length(); i++) {
            for (var j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) == s3.charAt(i+j+1)) {
                    if (dp[i+1][j]) dp[i+1][j+1] = true;
                } 
                if (s1.charAt(i) == s3.charAt(i+j+1)) {
                    if (dp[i][j+1]) dp[i+1][j+1] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
