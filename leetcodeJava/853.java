package leetcodeJava;

class Solution {
    class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        var pairs = new pair[position.length];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new pair(position[i], speed[i]);
        }
        Arrays.sort(pairs, (x, y) -> {return x.x - y.x;});
        int res = 0;
        for (int i = position.length-1; i>=0; i--) {
            for (int j = i-1; j >= -1; j--) {
                double t = (target - pairs[i].x) * 1.0 / pairs[i].y;
                if (j == -1 || t * pairs[j].y < target - pairs[j].x) {
                    i = j+1;
                    break;
                }
            }
            res++;
        }
        return res;
    }
}
