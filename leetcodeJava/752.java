package leetcodeJava;

class Solution {
    public int openLock(String[] deadends, String target) {
        var set = new HashSet<String>();
        for (var d : deadends) {
            set.add(d);
        }
        if (set.contains("0000")) return -1;
        var visited = new HashSet<String>();
        var q = new LinkedList<String>();
        q.add("0000");
        visited.add("0000");
        var res = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            while (size-- > 0) {
                var cur = q.removeFirst();
                if (cur.equals(target)) return res;
                var arr = cur.toCharArray();
                for (int i = 0; i < 4; i++) {
                    var ch = arr[i];
                    if (ch == '0') {
                        arr[i] = '9';
                    } else {
                        arr[i] -= 1;
                    }
                    var s = String.valueOf(arr);
                    if (!set.contains(s) && !visited.contains(s)) {
                        visited.add(s);
                        q.add(s);
                    }
                    arr[i] = ch;
                    if (ch == '9') {
                        arr[i] = '0';
                    } else {
                        arr[i] += 1;
                    }
                    s = String.valueOf(arr);
                    if (!set.contains(s) && !visited.contains(s)) {
                        visited.add(s);
                        q.add(s);
                    }
                    arr[i] = ch;
                }
            }
            res++;
        }
        return -1;
    }
}
