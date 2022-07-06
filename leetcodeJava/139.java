package leetcodeJava;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var dp = new boolean[s.length()+1];
        var dict = new HashSet<String>();
        wordDict.stream().forEach(x -> dict.add(x));
        dp[0] = true;
        for (var i = 1; i <= s.length(); i++) {
            for(var j=0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
