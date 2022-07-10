class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        var dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        for (var i = 1; i <= s1.length(); i++) {
            for (var j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        var sum = 0;
        for (var ch : s1.toCharArray()) sum += ch;
        for (var ch : s2.toCharArray()) sum += ch;
        return sum - dp[s1.length()][s2.length()]*2;
    }
}