package leetcodeJava;

class Solution {
    private void union(int[] set, int i, int j) {
        set[find(set, j)] = find(set, i);
    }
    private int find(int[] set, int i) {
        if (set[i] == i) return i;
        else {
            var root = find(set, set[i]);
            set[i] = root;
            return root;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        var map = new HashMap<String, Integer>();
        var set = new int[accounts.size()];
        for (var i = 0; i < set.length; i++) {
            set[i] = i;
        }
        for (int i = 0; i < accounts.size(); i++) {
            var l = accounts.get(i);
            for (int j = 1; j < l.size(); j++) {
                var index = map.get(l.get(j));
                if (index == null) {
                    map.put(l.get(j), Integer.valueOf(i));
                } else {
                    union(set, index.intValue(), i);
                }
            }
        }
        var res = new HashMap<Integer, List<String>>();
        for (var i = 0; i < set.length; i++) {
            var root = find(set, i);
            var l = res.getOrDefault(Integer.valueOf(root), new LinkedList<String>());
            var list = accounts.get(i);
            l.addAll(list.subList(1, list.size()));
            res.put(Integer.valueOf(root), l);
        }
        var ans = new LinkedList<List<String>>();
        for (var entry : res.entrySet()) {
            var l = entry.getValue();
            l = l.stream().distinct().sorted().collect(Collectors.toList());
            l.add(0, accounts.get(entry.getKey().intValue()).get(0));
            ans.add(l);
        }
        return ans;
    }
}
