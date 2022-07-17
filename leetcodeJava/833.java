package leetcodeJava;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < indices.length; i++) {
            map.put(Integer.valueOf(indices[i]), Integer.valueOf(i));
        }
        var res =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(Integer.valueOf(i))) {
                res.append(s.charAt(i));
            } else {
                int index = map.get(Integer.valueOf(i)).intValue();
                var match = true;
                for (int j = 0; j < sources[index].length(); j++) {
                    if (i+j >= s.length() || s.charAt(i+j) != sources[index].charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    res.append(targets[index]);
                    i += sources[index].length()-1;
                } else {
                    res.append(s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}
