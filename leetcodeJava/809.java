package leetcodeJava;

class Solution {
    public int expressiveWords(String s, String[] words) {
        var res = 0;
        for (var word: words) {
            int i = 0, j = 0;
            boolean find = true;
            while (i < s.length() && j < word.length()) {
                int count1 = 1, count2 = 1;
                if (s.charAt(i) != word.charAt(j)) {
                    find = false;
                    break;
                }
                while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                    i++;
                    count1++;
                }
                while (j+1 < word.length() && word.charAt(j) == word.charAt(j+1)) {
                    j++;
                    count2++;
                }
                
                if (count1 < 3 && count1 != count2 || count1 < count2) {
                    find = false;
                    break;
                }
                
                i++;
                j++;
            }
            if (find && i == s.length() && j == word.length()) res++;
        }
        return res;
    }
}
