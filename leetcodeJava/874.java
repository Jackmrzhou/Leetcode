import java.util.HashSet;

class Solution {
    class pair {
        int i, j;
        public pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public int hashCode() {
            return i;
        }
        @Override 
        public boolean equals(Object o) {
            var obj = (pair) o;
            return obj.i == i && obj.j == j;
        }
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        var set = new HashSet<pair>();
        for (var o : obstacles) {
            set.add(new pair(o[0], o[1]));
        }
        int x = 0, y = 0;
        var dirs = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int curDir = 0;
        var flag = false;
        int res = 0;
        for (var cmd : commands) {
            if (cmd == -2) {
                curDir = (curDir+3) % 4;
                flag = false;
            } else if (cmd == -1) {
                curDir = (curDir+1) % 4;
                flag = false;
            } else {
                if (flag) {
                    continue;
                }
                for (int i = 0; i < cmd; i++) {
                    x += dirs[curDir][0];
                    y += dirs[curDir][1];
                    if (set.contains(new pair(x, y))) {
                        x -= dirs[curDir][0];
                        y -= dirs[curDir][1];
                        flag = true;
                        res = Math.max(res, x*x+y*y);
                        break;
                    }
                    res = Math.max(res, x*x+y*y);
                }
            }
        }
        return res;
    }
}