package leetcodeJava;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        var map = new HashMap<Character, List<Integer>>();
        
        for (int i = 0; i < s.length(); i++) {
            var list = map.getOrDefault(Character.valueOf(s.charAt(i)), new ArrayList());
            list.add(Integer.valueOf(i));
            map.put(Character.valueOf(s.charAt(i)), list);
        }
        
        var res = 0;
        for (var word : words) {
            if (test(word, map)) res += 1;
        }
        return res;
    }
    
    private int minGreater(List<Integer> list, int target) {
        int l = 0, r = list.size()-1;
        while(l < r) {
            int mid = (r-l)/2 + l;
            int val = list.get(mid).intValue();
            if (val <= target) l = mid+1;
            else r = mid;
        }
        if (list.get(l).intValue() <= target) return -1;
        return list.get(l).intValue();
    }
    
    private boolean test(String word, Map<Character, List<Integer>> map) {
        int prev = -1;
        for (int i = 0; i < word.length(); i++) {
            var list = map.get(Character.valueOf(word.charAt(i)));
            if (list == null) return false;
            if (prev == -1) {
                prev = list.get(0).intValue();
                continue;
            }
            
            var index = minGreater(list, prev);
            if (index == -1) return false;
            prev = index;
        }
        return true;
    }
}
