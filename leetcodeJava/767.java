class Solution {
    public String reorganizeString(String s) {
        var charMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a'] += 1;
        }
        var max = -1;
        for (int i = 0; i < 26; i++) 
            if (max == -1 || charMap[max] < charMap[i]) max = i;
        if (charMap[max] > (s.length()+1)/2) return "";
        var res = new char[s.length()];
        var idx = 0;
        for (idx = 0; idx < res.length && charMap[max] > 0; idx+=2) {
            res[idx] = (char)('a' + max);
            charMap[max] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            while (charMap[i] > 0) {
                if (idx >= res.length) idx = 1;
                res[idx] = (char)('a' + i);
                charMap[i] -= 1;
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
}