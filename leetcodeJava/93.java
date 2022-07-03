package leetcodeJava;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        var res = dfs(s, 4);
        if (res == null) return new LinkedList();
        return res;
    }
    private List<String> dfs(String s, int left) {
        if (s.length() == 0 && left != 0) return null;
        if (left == 0) {
            if (s.length() != 0) return null;
            else return new LinkedList<String>();
        } else {
            var len = Math.min(s.length(), 3);
            if (s.charAt(0) == '0') {
                len = 1;
            }
            var res = new LinkedList<String>();
            for (var i = 0; i < len; i++) {
                if (Integer.valueOf(s.substring(0, i+1)) <= 255) {
                    var l = dfs(s.substring(i+1, s.length()), left-1);
                    if (l != null) {
                        if (l.size() == 0) {
                            res.add(s.substring(0, i+1));
                        } else {
                            for (var str : l) {
                                res.add(s.substring(0, i+1) + "." + str);
                            }
                        }
                    }
                }
            }
            if (res.size() == 0) return null;
            return res;
        }
    }
}
