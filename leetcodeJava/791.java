package leetcodeJava;

class Solution {
    public String customSortString(String order, String s) {
        var map = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            var count = map.getOrDefault(Character.valueOf(s.charAt(i)), Integer.valueOf(0));
            map.put(Character.valueOf(s.charAt(i)), Integer.valueOf(count.intValue() + 1));
        }
        var res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            var count = map.get(Character.valueOf(order.charAt(i)));
            if (count != null) {
                res.append(String.valueOf(order.charAt(i)).repeat(count.intValue()));
            }
            map.remove(Character.valueOf(order.charAt(i)));
        }
        for (var entry : map.entrySet()) {
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()));
        }
        return res.toString();
    }
}
