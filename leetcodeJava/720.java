package leetcodeJava;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        memo = new HashMap<String, Boolean>();
        var map = new HashMap<Integer, List<String>>();
        for (var w : words) {
            var len = Integer.valueOf(w.length());
            var list = map.getOrDefault(len, new LinkedList<String>());
            list.add(w);
            map.put(len, list);
            minLen = Math.min(minLen, len);
        }
        if (minLen != 1) return "";
        var res = "";
        for (var word : words) {
            if (dfs(map, word) && word.length() > res.length()) res = word;
        }
        return res;
    }
    
    private Map<String, Boolean> memo;
    private int minLen = 31;
    private boolean dfs(Map<Integer, List<String>> map, String word) {
        if (word.length() == minLen) return true;
        if (memo.get(word) != null) {
            return memo.get(word).booleanValue();
        }
        
        var len = word.length();
        var l = map.get(Integer.valueOf(len-1));
        if (l == null) {
            memo.put(word, new Boolean(false));
            return false;
        }
        
        for (var w : l) {
            if ((word.substring(1, len).equals(w) || word.substring(0, len-1).equals(w)) && dfs(map, w)) {
                memo.put(word, new Boolean(true));
                return true;
            }
        }
        memo.put(word, new Boolean(false));
        return false;
    }
}
